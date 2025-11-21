package model.effects

import model.board.Board
import model.board.row.Row
import model.board.side.Side
import model.buffs.buff.MoraleSupported
import model.cards.{Card, CardWithStrength}

class MoraleSupport(r: Row) extends Effect {
  override def apply(from: Card, b: Board, s: Side): Unit = {
    b.cards(s, r).foreach(c => if from != c then c.addBuff(MoraleSupported))
  }
}
