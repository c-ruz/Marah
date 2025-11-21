package model.buffs.debuff

import model.buffs.Condition

object InBitingFrost extends Condition {
  override def modifier: Int => Int = _ => 1
}
