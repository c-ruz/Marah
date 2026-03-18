package model.actions

import controller.GameController

class Pass extends Action {
  val name = "Pass"
  override def doAction(c: GameController): String = {
    val player = c.currentPlayer
    c.pass()
    s"${player.name} passed their turn."
  }
}
