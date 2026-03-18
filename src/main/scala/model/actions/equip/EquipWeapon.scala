package model.actions.equip

import api.{ActionResult, Failure, Success}
import controller.GameController
import controller.states.SelectEquipWeapon
import model.actions.Action
import model.entities.characters.Character

class EquipWeapon extends Action {

  val name: String = "Equip"

  def doAction(c: GameController): ActionResult = {
    c.currentTurn match {
      case _: Character =>
        c.state = new SelectEquipWeapon(c)
        Success("Select a weapon to equip")
      case _ =>
        Failure("Only characters can equip weapons")
    }
  }
}
