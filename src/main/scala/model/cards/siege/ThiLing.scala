package model.cards.siege

import model.board.row.Siege
import model.cards.SiegeCard
import model.effects.{Effect, MoraleSupport}

class ThiLing extends SiegeCard("ThiLing", 20) {

  override def effects: Seq[Effect] = List(MoraleSupport(Siege))
}
