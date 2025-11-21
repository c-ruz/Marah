package model.player

import model.board.side.Side
import model.cards.Card
import model.cards.ranged.{Eita, ZeehRanged}
import model.cards.siege.{ThiLing, ZeehSiege}
import model.cards.melee.{Asmuth, WuQi}

import java.util.UUID

class Player(val side: Side, val name: String = "") {
  val id: String = UUID.randomUUID().toString
  private var _hand = List[Card]()
  private var _deck = List(
    Asmuth(),
    Asmuth(),
    Asmuth(),
    WuQi(),
    WuQi(),
    WuQi(),
    Eita(),
    Eita(),
    Eita(),
    ZeehRanged(),
    ZeehRanged(),
    ZeehRanged(),
    ZeehSiege(),
    ZeehSiege(),
    ZeehSiege(),
    ThiLing(),
    ThiLing(),
    ThiLing()
  )

  def hand: List[Card] = _hand
  def removeCardFromHandAt(index: Int): Card = {
    val card = _hand(index)
    _hand = _hand.filterNot(_ == card)
    card
  }

  def draw(n: Int): Unit =
    _hand = _hand ++ _deck.take(n)
    _deck = _deck.drop(n)

  def shuffleDeck(): Unit =
    _deck = scala.util.Random.shuffle(_deck)

}
