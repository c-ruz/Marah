package model.cards.ranged

import model.board.row.Melee
import model.cards.RangedCard
import model.effects.{Effect, MoraleSupport}

class Eita extends RangedCard("Eita", 10) {

  override def effects: Seq[Effect] = List(MoraleSupport(Melee))
}
