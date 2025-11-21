package model.cards

import api.types.grid.components.CellEntityAttribute
import model.board.side.Side
import model.board.Board

import java.util.UUID

abstract class WeatherCard(val name: String) extends Card {
  val id: String = UUID.randomUUID().toString
  override def play(b: Board, s: Side): Unit = {
    b.placeWeather(this)
  }

  def apply(b: Board): Unit

  def unApply(b: Board): Unit

  override def attributes: List[CellEntityAttribute] = List()
}
