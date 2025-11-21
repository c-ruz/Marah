package model.cards.melee

import model.board.row.{Melee, Ranged}
import model.cards.MeleeCard
import model.effects.{Effect, MoraleSupport}

class WuQi extends MeleeCard("WuQi", 5) {

  override def effects: Seq[Effect] =
    List(MoraleSupport(Melee), MoraleSupport(Ranged))
}
