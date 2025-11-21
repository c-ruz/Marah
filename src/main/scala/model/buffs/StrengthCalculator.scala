package model.buffs

import model.buffs.buff.{MoraleSupported, TightBonded}
import model.buffs.debuff.InBitingFrost

object StrengthCalculator {
  private val conditionPriority = Map(
    MoraleSupported -> 0,
    TightBonded -> 1,
    InBitingFrost -> 2
  )

  def calculate(
      initial: Int,
      buffs: List[Condition],
      debuffs: List[Condition]
  ): Int = {
    val sortedBuffs = buffs
      .concat(debuffs)
      .sortBy(buff => conditionPriority.getOrElse(buff, Int.MaxValue))
    sortedBuffs.foldLeft(initial)((value, buff) => buff.modifier(value))
  }
}
