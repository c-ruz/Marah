package model.entities.characters

import model.entities.GameEntity
import model.weapons.Weapon

trait Character extends GameEntity {
  
  def baseWeight: Int
  def weapon: Option[Weapon]
  def equipWeapon(w: Weapon): Unit 
}
