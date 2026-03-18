package model.weapons

import model.entities.characters.Paladin

class Axe(name: String = "Axe", attack: Int = 10, weight: Int = 10) extends CommonWeapon(name, attack, weight) {

  override def equipToPaladin(p: Paladin): Unit = 
    _owner = Some(p)
}
