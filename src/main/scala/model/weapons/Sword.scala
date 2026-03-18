package model.weapons

import model.entities.characters.Paladin

class Sword(name: String = "Sword", attack: Int = 10, weight: Int = 10) extends CommonWeapon(name, attack, weight) {

  override def equipToPaladin(p: Paladin): Unit = 
    _owner = Some(p)
}
