package controller.states.state

import controller.GameController
import controller.states.GameState
import model.actions.Action
import model.player.Player

class GameEnded(winner: Player) extends GameState {
  println(s"Game ended with ${winner.side} winning")

  override def getAvailableActions(c: GameController): List[Action] = {
    List(
      new model.actions.PlayAgain()
    )
  }
}
