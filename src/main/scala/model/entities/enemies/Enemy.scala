package model.entities.enemies

import model.entities.GameEntity

class Enemy(
           val name: String,
           val health: Int,
           val attack: Int,
           val defense: Int,
           val weight: Int,
           val img: Option[String]
           ) extends GameEntity {

  private var _currentHealth: Int = health
  def currentHealth: Int = _currentHealth
  def health_=(newHealth: Int): Unit = _currentHealth = math.min(math.max(0, newHealth), health)

  private var _currentActionBar = 0
  override def currentActionBar: Int = _currentActionBar
  override def currentActionBar_=(newAB: Int): Unit = _currentActionBar = math.max(0, newAB)
  override def actionBarString: String = {
    val filled = "█" * (currentActionBar * 10 / weight)
    val empty = "░" * (10 - (currentActionBar * 10 / weight))
    s"[$filled$empty]"
  }
}
