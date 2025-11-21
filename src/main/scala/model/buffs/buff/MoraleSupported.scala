package model.buffs.buff

import model.buffs.Condition

object MoraleSupported extends Condition {
  override def modifier: Int => Int = n => n + 1
}
