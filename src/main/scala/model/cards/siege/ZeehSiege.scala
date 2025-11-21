package model.cards.siege

import model.board.row.Ranged
import model.cards.SiegeCard
import model.effects.{Effect, TightBond}

class ZeehSiege extends SiegeCard("Zeeh", 30) {

  override def effects: Seq[Effect] = List(TightBond(Ranged))
}
