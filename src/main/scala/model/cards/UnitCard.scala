package model.cards

import api.types.grid.components.CellEntityAttribute
import model.buffs.{Condition, StrengthCalculator}

import java.util.UUID

abstract class UnitCard(val name: String, val strength: Int)
    extends CardWithStrength {
  val id: String = UUID.randomUUID().toString
  private var _buffs = List[Condition]()
  private var _debuffs = List[Condition]()

  override def buffs: List[Condition] = _buffs
  override def debuffs: List[Condition] = _debuffs

  override def addBuff(b: Condition): Unit =
    _buffs = _buffs :+ b
  override def removeBuff(b: Condition): Unit =
    _buffs = _buffs.filterNot(_ == b)

  override def addDebuff(b: Condition): Unit =
    _debuffs = _debuffs :+ b
  override def removeDebuff(b: Condition): Unit =
    _debuffs = _debuffs.filterNot(_ == b)

  override def strengthWithBuffs: Int = {
    StrengthCalculator.calculate(strength, buffs, debuffs)
  }

  override def attributes: List[CellEntityAttribute] = List(
    CellEntityAttribute("Strength", strengthWithBuffs.toString)
  )
}
