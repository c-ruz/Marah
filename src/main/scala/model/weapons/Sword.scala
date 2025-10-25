package model.weapons

import model.entities.characters.Paladin

class Sword extends CommonWeapon ("Sword", 10, 10){

  override def equipToPaladin(p: Paladin): Unit = 
    _owner = Some(p)
}
