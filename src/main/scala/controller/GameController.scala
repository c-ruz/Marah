package controller

import api.types.grid.components.{CellEntity, CellEntityAttribute, ScoreView}
import api.types.stack.StackGame
import api.types.stack.components.{Alignment, Horizontal, StackCell, Vertical}
import controller.states.State
import controller.states.state.{GameEnded, Player1Turn}
import model.actions.{Action, PlayCard}
import model.board.Board
import model.board.row.{Melee, Ranged, Siege}
import model.player.Player

class GameController extends StackGame {

  /** GWENT STUFF
   */

  var player1: Player = Player(model.board.side.Blue, name = "Player 1")
  player1.shuffleDeck()
  player1.draw(3)
  var player2: Player = Player(model.board.side.Red, name = "Player 2")
  player2.shuffleDeck()
  player2.draw(3)
  var board: Board = new Board

  private var life = Map(player1 -> 3, player2 -> 3)
  private var _currentPlayerId: String = player1.id
  def currentPlayerId_=(id: String): Unit = _currentPlayerId = id
  def currentPlayer: Player =
    if _currentPlayerId == player1.id then player1
    else player2
  private var _state: State = new Player1Turn(extended = false)

  def changeState(s: State): Unit = _state = s
  def state: State = _state

  private def hit(p: Player): Unit = life += p -> (life(p) - 1)

  def checkScore(): Unit = {
    val score = board.computeScore

    if score.red > score.blue then hit(player1)
    else if score.blue > score.red then hit(player2)

    if life.values.exists(_ == 0) then
      changeState(new GameEnded(life.maxBy(_._2)._1))
    else changeState(new Player1Turn(extended = false))
  }

  def play(index: Int): Unit =
    state.play(this, index)

  def pass(): Unit = {
    state.pass(this)
  }

  def playAgain(): Unit = {
    player1 = Player(model.board.side.Blue, name = "Player 1")
    player1.shuffleDeck()
    player1.draw(3)
    player2 = Player(model.board.side.Red, name = "Player 2")
    player2.shuffleDeck()
    player2.draw(3)
    board = new Board

    life = Map(player1 -> 3, player2 -> 3)
    _currentPlayerId = player1.id

    _state = new Player1Turn(extended = false)
  }

  /**
   * STACK GAME STUFF
   */

  /**
   * Defines the direction the cells will be rendered.
   * It can be either "vertical" or "horizontal"
   */
  def direction: Alignment = Vertical

  def stack: List[StackCell] = List(
    StackCell(label = Some("Hand"), entities = currentPlayer.hand.zipWithIndex.map((c, i) => CellEntity(c.name, c.attributes, List(new PlayCard(i)), None))),
    StackCell(label = Some("Player 1 Siege Row"), entities = for card <- board.cards(player1.side, Siege)
        yield CellEntity(card.name, List(CellEntityAttribute("Strength", card.strength.toString), CellEntityAttribute("Type", card.getClass.getSimpleName)), List(), None)),
    StackCell(label = Some("Player 1 Ranged Row"), entities = for card <- board.cards(player1.side, Ranged)
      yield CellEntity(card.name, card.attributes, List(), None)),
    StackCell(label = Some("Player 1 Melee Row"), entities = for card <- board.cards(player1.side, Melee)
      yield CellEntity(card.name, card.attributes, List(), None)),
    StackCell(label = Some("Weather Slot"), entities = board.weatherSlotCard.map(c => CellEntity(c.name, c.attributes, List(), None))),
    StackCell(label = Some("Player 2 Melee Row"), entities = for card <- board.cards(player2.side, Melee)
      yield CellEntity(card.name, card.attributes, List(), None)),
    StackCell(label = Some("Player 2 Ranged Row"), entities = for card <- board.cards(player2.side, Ranged)
      yield CellEntity(card.name, card.attributes, List(), None)),
    StackCell(label = Some("Player 2 Siege Row"), entities = for card <- board.cards(player2.side, Siege)
      yield CellEntity(card.name, card.attributes, List(), None)),
  )

  /** List of [[ScoreView]] to be shown in the bottom menu.
   */
  def score: List[ScoreView] = List(
    ScoreView("Red Side Life", life(player2).toString),
    ScoreView("Blue Side Life", life(player1).toString)
  )

  /** Message for feedback to the user, rendered in the top bar of the
   * visualizer. Use it to provide the user with directions regarding the
   * current state of the game.
   */
  def topBarMessage: Option[String] = Some(s"Current player: ${currentPlayer.name}")

  /** List of [[Action]] to be shown in the bottom menu of the visualizer.
   */
  def menuActions: List[Action] = state.getAvailableActions(this)
}
