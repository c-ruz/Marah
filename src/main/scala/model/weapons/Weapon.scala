package model.weapons

import model.entities.characters.{BlackMage, Character, Paladin, WhiteMage}
import model.spells.Spell

trait Weapon {
  def name: String
  def attack: Int
  def weight: Int
  
  def owner: Option[Character]
  def unequip(): Unit
  
  def equipToPaladin(p: Paladin): Unit
  def equipToWhiteMage(w: WhiteMage): Unit
  def equipToBlackMage(b: BlackMage): Unit
  
  def doSpell(s: Spell): Unit
}
