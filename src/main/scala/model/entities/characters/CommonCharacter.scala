package model.entities.characters

import model.weapons.Weapon

abstract class CommonCharacter(
                              val name: String,
                              val defense: Int,
                              val baseWeight: Int,
                              val health: Int,
                              val img: Option[String]
                              ) extends Character {
  
  private var _currentHealth: Int = health
  def health_=(newHealth: Int): Unit = _currentHealth = math.min(math.max(0, newHealth), health)
  def currentHealth: Int = _currentHealth
  
  override def attack: Int = _weapon.map(_.attack).getOrElse(0)
  override def weight: Int = (_weapon.map(_.weight).getOrElse(0) + baseWeight * .5).toInt
  
  private var _weapon: Option[Weapon] = None
  override def weapon: Option[Weapon] = _weapon
  protected def weapon_=(w: Weapon): Unit = {
    if _weapon.isDefined then _weapon.get.unequip()
    _weapon = Some(w)
  }

  private var _currentActionBar = 0
  override def currentActionBar: Int = _currentActionBar
  override def currentActionBar_=(newAB: Int): Unit = _currentActionBar = math.max(0, newAB)

  override def actionBarString: String = {
    val filled = "█" * (currentActionBar * 10 / weight)
    val empty = "░" * (10 - (currentActionBar * 10 / weight))
    s"[$filled$empty | $currentActionBar/$weight]"
  }
}
