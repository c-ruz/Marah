package model.entities.characters

import model.weapons.Weapon

class Paladin extends CommonCharacter("Paladin", 10, 10, 10, Some("paladin.png")) {

  def equipWeapon(w: Weapon): Unit = {
    w.equipToPaladin(this)
    weapon = w
  }
}
