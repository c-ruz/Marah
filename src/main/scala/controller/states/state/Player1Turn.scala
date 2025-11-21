package controller.states.state

import controller.GameController
import controller.states.GameState
import model.actions.{Action, Pass, PlayCard}

class Player1Turn(extended: Boolean) extends GameState {

  override def play(c: GameController, cardIndex: Int): Unit = {
    println(s"Player 1 playing card $cardIndex")
    val board = c.board
    val card = c.player1.removeCardFromHandAt(cardIndex)
    card.play(board, c.player1.side)
    if !extended then {
      c.currentPlayerId_=(c.player2.id)
      c.changeState(Player2Turn(extended = false))
    }
  }

  override def pass(c: GameController): Unit = {
    println("Passing PLAYER 1")
    if !extended then {
      c.currentPlayerId_=(c.player2.id)
      c.changeState(new Player2Turn(extended = true))
    } else {
      c.player1.draw(3)
      c.player2.draw(3)
      c.checkScore()
    }
  }

  override def getAvailableActions(c: GameController): List[Action] = {
    List {
      new Pass
    }
  }
}
