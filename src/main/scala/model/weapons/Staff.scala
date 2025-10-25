package model.weapons

import model.entities.characters.{BlackMage, WhiteMage}

class Staff extends MagicWeapon ("Staff", 10, 10, 100) {

  override def equipToBlackMage(b: BlackMage): Unit = {
    _owner = Some(b)
  }

  override def equipToWhiteMage(w: WhiteMage): Unit = {
    _owner = Some(w) 
  }
}
