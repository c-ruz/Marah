package model.weapons

import model.entities.characters.{BlackMage, WhiteMage}

class Wand extends MagicWeapon ("Wand", 10, 10, 100) {

  override def equipToWhiteMage(w: WhiteMage): Unit = 
    _owner = Some(w)

  override def equipToBlackMage(b: BlackMage): Unit = 
    _owner = Some(b)
}
