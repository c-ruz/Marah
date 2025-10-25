package model.entities.characters

import model.weapons.Weapon

abstract class CommonCharacter(
                              val name: String,
                              val defense: Int,
                              val weight: Int,
                              val health: Int,
                              val img: Option[String]
                              ) extends Character {
  
  private var _currentHealth: Int = health
  def health_=(newHealth: Int): Unit = _currentHealth = math.min(math.max(0, newHealth), health)
  def currentHealth: Int = _currentHealth
  
  override def attack: Int = _weapon.map(_.attack).getOrElse(0)
  
  private var _weapon: Option[Weapon] = None
  override def weapon: Option[Weapon] = _weapon
  protected def weapon_=(w: Weapon): Unit = {
    if _weapon.isDefined then _weapon.get.unequip()
    _weapon = Some(w)
  }
}
