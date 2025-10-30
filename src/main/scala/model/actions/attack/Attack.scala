package model.actions.attack

import api.{ActionResult, Success}
import controller.GameController
import controller.states.SelectTarget
import model.actions.Action

class Attack extends Action {

  val name: String = "Attack"

  def doAction(c: GameController): ActionResult = {
    c.state = new SelectTarget
    Success("Select a target")
  }
}
