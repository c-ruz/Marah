package model.cards

import api.types.grid.components.CellEntityAttribute
import model.board.row.Siege
import model.board.side.Side
import model.board.Board

abstract class SiegeCard(
    name: String,
    strength: Int
) extends UnitCard(name, strength) {
  override def play(b: Board, s: Side): Unit = {
    b.placeUnitCard(this, s, Siege)
  }

  override def attributes: List[CellEntityAttribute] = super.attributes :+ CellEntityAttribute("Type", "Siege")
}
