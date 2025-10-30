package model.entities.characters

import model.weapons.Weapon

class WhiteMage extends MagicCharacter("White Mage", 10, 8, 10, 100, Some("white_mage.png")) {

  def equipWeapon(w: Weapon): Unit = {
    w.equipToWhiteMage(this)
    weapon = w
  }
}
