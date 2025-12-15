package controller

import api.types.grid.GridGame
import api.types.grid.components.{Cell, CellEntity, ScoreView}
import controller.states.{InitialState, State}
import model.actions.Action
import model.entities.GameEntity
import model.entities.enemies.Enemy
import model.entities.characters.{BlackMage, Paladin, WhiteMage}
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
  def menuActions: List[Action] = state.menuActions()

  /** Defines the grid to be rendered. First value defines the horizontal span
   * of the grid, second value defines the vertical span of the grid.
   */
  def gridSize: (Int, Int) = (4,3)

  /** List of [[Cell]] to be rendered inside the grid.
   */
  def cells: List[Cell] = state.cells
}
