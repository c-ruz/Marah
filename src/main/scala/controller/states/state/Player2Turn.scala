package controller.states.state

import controller.GameController
import controller.states.GameState
import model.actions.{Action, Pass, PlayCard}

class Player2Turn(extended: Boolean) extends GameState {

  override def play(c: GameController, cardIndex: Int): Unit = {
    println(s"Player 2 playing card $cardIndex")
    val board = c.board
    val card = c.player2.removeCardFromHandAt(cardIndex)
    card.play(board, c.player2.side)
    if !extended then {
      c.currentPlayerId_=(c.player1.id)
      c.changeState(Player1Turn(extended = false))
    }
  }

  override def pass(c: GameController): Unit = {
    println("Passing PLAYER 2")
    if !extended then {
      c.currentPlayerId_=(c.player1.id)
      c.changeState(new Player1Turn(extended = true))
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
