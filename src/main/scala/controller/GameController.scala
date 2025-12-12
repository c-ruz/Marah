package controller

import api.types.grid.GridGame
import api.{ActionResult, Success}
import api.types.grid.components.{Cell, CellEntity, CellEntityAttribute, ScoreView}
import api.types.stack.StackGame
import api.types.stack.components.StackCell
import controller.states.{InitialState, State}
import model.actions.Action
import model.entities.GameEntity
import model.entities.enemies.Enemy
import model.entities.characters.{BlackMage, Character, Paladin, WhiteMage}
import model.turns.TurnScheduler

class GameController extends GridGame {
  
  var state: State = new InitialState
  
  val enemy = new Enemy("Enemy 1", 100, 10, 10, 10, Some("bahamut.png"))

  val paladin = new Paladin

  val whiteMage = new WhiteMage

  val blackMage = new BlackMage

  private val scheduler = new TurnScheduler(entities = List(enemy, paladin, whiteMage, blackMage))

  var currentTurn: GameEntity = scheduler.nextTurn()


  /** List of [[ScoreView]] to be shown in the bottom menu.
   */
  def score: List[ScoreView] =
    List(enemy, paladin, whiteMage, blackMage).map(e => ScoreView(e.name, e.actionBarString))


  /** Message for feedback to the user, rendered in the top bar of the
   * visualizer. Use it to provide the user with directions regarding the
   * current state of the game.
   */
  def topBarMessage: Option[String] = Some(s"Turn of ${currentTurn.name}")

  /** List of [[Action]] to be shown in the bottom menu of the visualizer.
   */
  def menuActions: List[Action] = List()

  /** Defines the grid to be rendered. First value defines the horizontal span
   * of the grid, second value defines the vertical span of the grid.
   */
  def gridSize: (Int, Int) = (4,3)

  /** List of [[Cell]] to be rendered inside the grid.
   */
  def cells: List[Cell] = List(
    Cell(None, 0, 1, List(CellEntity(name = "Enemy", attributes = List(), actions = List(), img = Some("bahamut.png"))), List(), None),
    Cell(None, 2, 0, List(CellEntity(paladin.name, List(), List(), paladin.img)), List(), None),
    Cell(None, 3, 1, List(CellEntity(blackMage.name, List(), List(), blackMage.img)), List(), None),
    Cell(None, 2, 2, List(CellEntity(whiteMage.name, List(), List(), whiteMage.img)), List(), None)
  )
}
