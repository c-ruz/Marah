package model.entities.characters

import model.weapons.Weapon

class BlackMage extends MagicCharacter("Black Mage", 10, 6, 10, 100, Some("black_mage.png")) {

  def equipWeapon(w: Weapon): Unit = {
    w.equipToBlackMage(this)
    weapon = w
  }
}
