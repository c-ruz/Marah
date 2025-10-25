package model.weapons

import model.entities.characters.Paladin

class Axe extends CommonWeapon ("Axe", 10, 10) {

  override def equipToPaladin(p: Paladin): Unit = 
    _owner = Some(p)
}
