package model.actions

import controller.GameController

class PlayAgain extends Action {
  val name = "Play Again"
  override def doAction(c: GameController): String = {
    c.playAgain()
    "Starting a new game."
  }
}
