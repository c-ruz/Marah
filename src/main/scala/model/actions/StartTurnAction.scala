package model.actions

import api.{ActionResult, Success}
import controller.GameController
import model.entities.PlayerCharacter

class StartTurnAction(player: PlayerCharacter) extends Action {
  val name: String = s"Start ${player.name}'s Turn"

  def doAction(c: GameController): ActionResult = {
    c.startTurn(player)
    Success("Starting Turn")
  }
}
