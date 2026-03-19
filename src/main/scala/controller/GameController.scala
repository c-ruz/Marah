package controller

import api.types.grid.GridGame
import api.types.grid.components.{Cell, CellEntity, ScoreView}
import controller.states.{InitialState, State}
import model.actions.Action
import model.entities.GameEntity
import model.entities.enemies.Enemy
import model.entities.characters.{BlackMage, Paladin, WhiteMage}
import model.panels.ConcretePanel
import model.turns.TurnScheduler
import model.weapons.{Axe, Staff, Sword, Wand, Weapon}
import scala.util.Random

class GameController extends GridGame {

  // --- Entities ---
  val enemy     = new Enemy("Enemy 1", 100, 10, 10, 10, Some("bahamut.png"))
  val paladin   = new Paladin
  val whiteMage = new WhiteMage
  val blackMage = new BlackMage

  val weaponPool: List[Weapon] = List(
    new Axe("Iron Axe", attack = 15, weight = 12),
    new Axe("Heavy Axe", attack = 22, weight = 20),
    new Sword("Steel Sword", attack = 12, weight = 8),
    new Sword("Broad Sword", attack = 18, weight = 14),
    new Staff("Oak Staff", attack = 8, weight = 6),
    new Wand("Magic Wand", attack = 7, weight = 5)
  )

  private val scheduler = new TurnScheduler(entities = List(enemy, paladin, whiteMage, blackMage))
  var currentTurn: GameEntity = scheduler.nextTurn()

  def advanceTurn(): Unit = {
    currentTurn.currentActionBar = 0
    currentTurn = scheduler.nextTurn()
  }

  // --- Map (must be initialised before state) ---

  private val cols = 4
  private val rows = 3

  /** 2-D grid of panels indexed as panels(row)(col). */
  val panels: Vector[Vector[ConcretePanel]] =
    Vector.tabulate(rows, cols)((y, x) => new ConcretePanel(x, y))

  // Connect every panel bidirectionally to its right and bottom neighbours.
  for {
    y <- 0 until rows
    x <- 0 until cols
  } {
    if (x + 1 < cols) {
      panels(y)(x).addAdjacentPanel(panels(y)(x + 1))
      panels(y)(x + 1).addAdjacentPanel(panels(y)(x))
    }
    if (y + 1 < rows) {
      panels(y)(x).addAdjacentPanel(panels(y + 1)(x))
      panels(y + 1)(x).addAdjacentPanel(panels(y)(x))
    }
  }

  /** Flat list of all panels, used to drive the view. */
  val allPanels: List[ConcretePanel] = panels.flatten.toList

  // Place each entity on a distinct randomly chosen panel.
  private val startingPanels = Random.shuffle(allPanels)
  startingPanels(0).addEntity(enemy)
  startingPanels(1).addEntity(paladin)
  startingPanels(2).addEntity(whiteMage)
  startingPanels(3).addEntity(blackMage)

  // --- State (allPanels must exist first) ---
  var state: State = new InitialState(this)

  // --- View ---

  def score: List[ScoreView] =
    List(enemy, paladin, whiteMage, blackMage).map(e => ScoreView(e.name, e.actionBarString))

  def topBarMessage: Option[String] = Some(s"Turn of ${currentTurn.name}")

  def menuActions: List[Action] = state.menuActions()

  def gridSize: (Int, Int) = (cols, rows)

  def cells: List[Cell] = state.cells
}
