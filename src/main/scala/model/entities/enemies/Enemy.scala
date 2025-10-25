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
}
