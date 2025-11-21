package model.board

import model.board.row.{Melee, Ranged, Row, Siege}
import model.board.side.{Blue, Red, Side}
import model.cards.{CardWithStrength, WeatherCard}

import scala.collection.mutable.ArrayBuffer

class Board {
  private val _cards: Map[(Side, Row), ArrayBuffer[CardWithStrength]] = Map(
    (Red, Melee) -> ArrayBuffer(),
    (Red, Ranged) -> ArrayBuffer(),
    (Red, Siege) -> ArrayBuffer(),
    (Blue, Melee) -> ArrayBuffer(),
    (Blue, Ranged) -> ArrayBuffer(),
    (Blue, Siege) -> ArrayBuffer()
  )

  def cards(side: Side, row: Row): List[CardWithStrength] =
    _cards(side, row).toList

  /** Weather Slot
    */
  private var weatherSlot: Option[WeatherCard] = None
  def weatherSlotCard: List[WeatherCard] = weatherSlot.toList

  def placeWeather(w: WeatherCard): Unit = {
    weatherSlot = Some(w)
  }

  def placeUnitCard(m: CardWithStrength, side: Side, row: Row): Unit = {
    _cards(side, row) += m
    m.effects.foreach(e => e.apply(m, this, side))
  }

  def computeScore: Score = {
    _cards.foldLeft(Score(0, 0))((score, entry) => {
      val ((side, row), cards) = entry
      val strength = cards.map(_.strengthWithBuffs).sum

      (side, row) match {
        case (Red, _)  => score.copy(red = score.red + strength)
        case (Blue, _) => score.copy(blue = score.blue + strength)
      }
    })
  }

}
