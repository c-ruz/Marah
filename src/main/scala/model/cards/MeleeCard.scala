package model.cards

import model.board.row.Melee
import model.board.side.Side
import model.board.Board

abstract class MeleeCard(
    name: String,
    strength: Int
) extends UnitCard(name, strength) {
  override def play(b: Board, s: Side): Unit = {
    b.placeUnitCard(this, s, Melee)
  }
}
