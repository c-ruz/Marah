package model.actions

import api.ActionResult
import controller.GameController

class RollDiceAction extends Action {
  val name: String = "Roll Dice"

  def doAction(c: GameController): ActionResult = c.rollDice()
}
