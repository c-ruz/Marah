package model.panels.kinds

import model.entities.WildUnit
import model.entities.kinds.{Chicken, RoboBall, Seagull}
import model.panels.AbsPanel

import scala.util.Random

class EncounterPanel(x: Int, y: Int) extends AbsPanel(x, y) {

  val img = "encounter.png"

  private val rng = new Random()
  private var _wildUnit: WildUnit = spawnWildUnit()

  def wildUnit: WildUnit = _wildUnit

  private def spawnWildUnit(): WildUnit = rng.nextInt(3) match {
    case 0 => new Chicken()
    case 1 => new RoboBall()
    case _ => new Seagull()
  }

  /** Replaces the current Wild Unit with a fresh one if it was defeated. */
  def respawnIfDefeated(): Unit = {
    if (_wildUnit.isDefeated) _wildUnit = spawnWildUnit()
  }
}
