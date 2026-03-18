package model.actions.attack

import api.{ActionResult, Failure, Success}
import controller.GameController
import controller.states.SelectTarget
import model.actions.Action
import model.entities.characters.Character

class Attack extends Action {

  val name: String = "Attack"

  def doAction(c: GameController): ActionResult = {
    c.currentTurn match {
      case ch: Character if ch.weapon.isEmpty =>
        Failure(s"${ch.name} has no weapon equipped")
      case _ =>
        c.state = new SelectTarget(c)
        Success("Select a target")
    }
  }
}
