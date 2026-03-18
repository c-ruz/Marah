package model.actions.move

import api.{ActionResult, Success}
import controller.GameController
import controller.states.SelectMoveTarget
import model.actions.Action

class MoveAction extends Action {

  val name: String = "Move"

  def doAction(c: GameController): ActionResult = {
    c.state = new SelectMoveTarget(c)
    Success(s"Select a panel to move ${c.currentTurn.name} to")
  }
}
