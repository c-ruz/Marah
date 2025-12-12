package model.cards

import api.types.grid.components.CellEntityAttribute
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

  override def attributes: List[CellEntityAttribute] =
    super.attributes :+ CellEntityAttribute("Type", "Melee")
}
