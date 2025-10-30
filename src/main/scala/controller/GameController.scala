package controller

import api.{ActionResult, Success}
import api.types.grid.components.{CellEntity, CellEntityAttribute, ScoreView}
import api.types.stack.StackGame
import api.types.stack.components.StackCell
import controller.states.{InitialState, State}
import model.actions.Action
import model.entities.GameEntity
import model.entities.enemies.Enemy
import model.entities.characters.{BlackMage, Character, Paladin, WhiteMage}
import model.turns.TurnScheduler

class GameController extends StackGame {
  
  var state: State = new InitialState
  
  private var enemies: List[Enemy] = List(
    new Enemy("Enemy 1", 100, 10, 10, 10, Some("bahamut.png"))
  )
  private var characters: List[Character] = List(new Paladin, new WhiteMage, new BlackMage)

  private val scheduler = new TurnScheduler(entities = enemies ++ characters)

  var currentTurn: GameEntity = scheduler.nextTurn()

  /**
   * Defines the direction the cells will be rendered.
   * It can be either "vertical" or "horizontal"
   */
  def direction: "vertical" | "horizontal" = "horizontal"

  def stack: List[StackCell] = List()
  /** List of [[ScoreView]] to be shown in the bottom menu.
   */
  def score: List[ScoreView] =
    (enemies ++ characters).map(e => ScoreView(e.name, e.actionBarString))


  /** Message for feedback to the user, rendered in the top bar of the
   * visualizer. Use it to provide the user with directions regarding the
   * current state of the game.
   */
  def topBarMessage: Option[String] = Some(s"Turn of ${currentTurn.name}")

  /** List of [[Action]] to be shown in the bottom menu of the visualizer.
   */
  def menuActions: List[Action] = List()
}
