package model.weapons

import model.entities.characters.{BlackMage, Character, Paladin, WhiteMage}
import model.spells.Spell

abstract class CommonWeapon(
                           val name: String,
                           val attack: Int,
                           val weight: Int
                           ) extends Weapon {

  protected var _owner: Option[Character] = None
  def owner: Option[Character] = _owner
  override def unequip(): Unit = _owner = None

  private def cantEquipMessage(targetName: String): String = {
    s"Can't equip weapon: $targetName can't use a ${this.getClass.getSimpleName}!"
  }

  override def equipToBlackMage(b: BlackMage): Unit = {
    throw new Exception(cantEquipMessage("Black Mage"))
  }

  override def equipToPaladin(p: Paladin): Unit =
    throw new Exception(cantEquipMessage("Paladin"))

  override def equipToWhiteMage(w: WhiteMage): Unit =
    throw new Exception(cantEquipMessage("White Mage"))

  override def doSpell(s: Spell): Unit =
    throw new Exception("You need a Magic Weapon to cast spells!")
}
