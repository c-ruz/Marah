package model.actions.attack

import api.{ActionResult, Success}
import controller.GameController
import controller.states.SelectTarget
import model.actions.{Action, Target}
import model.entities.enemies.Enemy

class Attack extends Action with Target {

  val name: String = "Attack"

  def doAction(c: GameController): ActionResult = {
    c.state = new SelectTarget(this)
    Success("Select a target")
  }

  def doToTarget(c:GameController, e: Enemy): Unit = {
    e.health = e.currentHealth - 10
  }
}
