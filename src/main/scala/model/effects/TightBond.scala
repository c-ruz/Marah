package model.effects

import model.board.Board
import model.board.row.Row
import model.board.side.Side
import model.buffs.buff.TightBonded
import model.cards.Card

class TightBond(r: Row) extends Effect {

  override def apply(from: Card, b: Board, s: Side): Unit = {
    b.cards(s, r)
      .foreach(c => if c.name == from.name then c.addBuff(TightBonded))
  }
}
