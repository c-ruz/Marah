package model.actions

import api.{ActionResult, Success}
import controller.GameController
import controller.states.kinds.AwaitingTurnStart

class EndTurnAction extends Action {
  val name: String = "End Turn"

  def doAction(c: GameController): ActionResult = {
    // Logic to get the next player
    c.turn = c.turn + 1
    c.map.connectMap()
    c.setState(AwaitingTurnStart())
    Success("Turn Ended")
  }
}
