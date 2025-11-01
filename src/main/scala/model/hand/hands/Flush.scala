package model.hand.hands

import model.base.{Card, Score}
import model.hand.APokerHand
import model.joker.Joker
import model.suit.suits.Spades

/**
 * Represents the Flush poker hand combination.
 *
 * A `Flush` is a hand where all five cards have the same suit, regardless of their ranks.
 * This class extends `APokerHand` and evaluates whether a given list of cards 
 * satisfies the conditions for a Flush.
 *
 * This hand is scored with 35 chips and a multiplier of 4.
 */
class Flush extends APokerHand(new Score(35,4)) {
}
