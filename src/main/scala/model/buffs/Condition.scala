package model.buffs

import model.cards.CardWithStrength

trait Condition:
  def modifier: Int => Int
