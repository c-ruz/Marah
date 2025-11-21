package model.cards

import model.board.row.Ranged
import model.board.side.Side
import model.board.Board

abstract class RangedCard(
    name: String,
    strength: Int
) extends UnitCard(name, strength) {
  override def play(b: Board, s: Side): Unit = {
    b.placeUnitCard(this, s, Ranged)
  }
}
