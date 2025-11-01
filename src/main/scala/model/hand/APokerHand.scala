package model.hand

import model.base.{Card, Score}
import model.rank.Rank
import model.suit.Suit

import scala.collection.mutable

abstract class APokerHand(val score: Score) extends PokerHand {
}
