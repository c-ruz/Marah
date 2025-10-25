package controller

import api.types.grid.components.{CellEntity, CellEntityAttribute, ScoreView}
import api.types.stack.StackGame
import api.types.stack.components.StackCell
import model.actions.{Action, ChooseCard, Discard, Play, RemoveCard}
import model.base.{Card, Score}
import model.joker.Joker
import model.joker.jokers.EvenSteven

class GameController extends StackGame {

  var chosenCards = List[Card]()
  var hand: List[Card] = Deck.draw(8)
  val jockers = List[Joker](
    new EvenSteven
  )
  var _score = 0
  
  var _topBarMessage: Option[String] = None

  /**
   * Defines the direction the cells will be rendered.
   * It can be either "vertical" or "horizontal"
   */
  def direction: "vertical" | "horizontal" = "vertical"

  /** List of [[Cell]] to be rendered inside the grid.
   */
  override def stack: List[StackCell] = List(
    StackCell(
      label = Some("Jokers"),
      entities = for
        joker <- jockers
      yield CellEntity(
        name = joker.toString,
        attributes = List(CellEntityAttribute(name = "Desc", value = joker.description)),
        actions = List(),
        img = Some("joker.png")
      ),
      actions = List(),
      img = None
    ),
    StackCell(
      label = None,
      entities = for
        card <- chosenCards
      yield CellEntity(
        name = card.toString,
        attributes = List(),
        actions = List(new RemoveCard(card)),
        img = Some(card.toString.replace(" ", "").toLowerCase + ".png")
      ),
      actions = List(),
      img = None
    ),
    StackCell(
      label = Some("Hand"),
      entities = for
        card <- hand
      yield CellEntity(
        name = card.toString,
        attributes = List(),
        actions = List(new ChooseCard(card)),
        img = Some(card.toString.replace(" ", "").toLowerCase + ".png")
      ),
      actions = List(),
      img = None
    )
  )

  /** List of [[ScoreView]] to be shown in the bottom menu.
   */
  def score: List[ScoreView] = List(
    ScoreView("Total Score", _score.toString),
  )
  /** Message for feedback to the user, rendered in the top bar of the
   * visualizer. Use it to provide the user with directions regarding the
   * current state of the game.
   */
  def topBarMessage: Option[String] = _topBarMessage
  /** List of [[Action]] to be shown in the bottom menu of the visualizer.
   */
  def menuActions: List[Action] = List(new Play, new Discard)
}
