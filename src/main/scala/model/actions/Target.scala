package model.actions

import controller.GameController
import model.entities.enemies.Enemy

trait Target {
  def doToTarget(c: GameController, e: Enemy): Unit
}
