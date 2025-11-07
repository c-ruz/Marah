package model.actions

import api.{ActionResult, Success}
import controller.GameController
import controller.states.kinds.MovingCharacter
import model.panels.Panel

class StopOnPanelAction(panel: Panel) extends Action {
  val name: String = "Stop on this panel"
  def doAction(c: GameController): ActionResult = {
    println("Player chose to stop.")
    c.remainingMoves = 0 // Force moves to 0
    c.setState(MovingCharacter()) // Go back to moving state
    c.processMove() // processMove will see 0 moves and trigger LandOn
    Success("Stoping")
  }
}
