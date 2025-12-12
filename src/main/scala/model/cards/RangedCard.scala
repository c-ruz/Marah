package model.cards

import api.types.grid.components.CellEntityAttribute
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

  override def attributes: List[CellEntityAttribute] = super.attributes :+ CellEntityAttribute("Type", "Ranged")

}
