package model.actions

import api.{ActionResult, Success}
import controller.GameController
import model.panels.Panel

class ChoosePanelAction(panel: Panel) extends Action {
  val name: String = s"Move to ${panel.getClass.getSimpleName} (${panel.x}, ${panel.y})"

  def doAction(c: GameController): ActionResult = {
    c.chooseNextPanel(panel)
    Success(s"Moving to ${panel.getClass.getSimpleName}")
  }
}
