package model.cards

import model.buffs.Condition
import model.effects.Effect

trait CardWithStrength extends Card {
  def strength: Int
  def strengthWithBuffs: Int

  def buffs: List[Condition]
  def debuffs: List[Condition]

  def addBuff(b: Condition): Unit
  def removeBuff(b: Condition): Unit

  def addDebuff(b: Condition): Unit
  def removeDebuff(b: Condition): Unit

  def effects: Seq[Effect]
}
