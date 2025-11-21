package model.buffs.buff

import model.buffs.Condition

object TightBonded extends Condition {
  override def modifier: Int => Int = c => c * 2
}
