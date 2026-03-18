package model.weapons

import model.entities.characters.{BlackMage, WhiteMage}

class Wand(name: String = "Wand", attack: Int = 10, weight: Int = 10, magicAttack: Int = 100) extends MagicWeapon(name, attack, magicAttack, weight) {

  override def equipToWhiteMage(w: WhiteMage): Unit = 
    _owner = Some(w)

  override def equipToBlackMage(b: BlackMage): Unit = 
    _owner = Some(b)
}
