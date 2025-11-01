package model.hand.hands

import model.base.{Card, Score}
import model.hand.APokerHand
import model.joker.Joker

/**
 * Represents a Straight Flush poker hand combination.
 *
 * A `StraightFlush` is a hand containing five cards of sequential rank, all in the same suit.
 * This class extends `APokerHand` and implements the logic to verify whether a given list 
 * of cards satisfies the condition of being a Straight Flush.
 */
class StraightFlush extends APokerHand(new Score(100, 8)) {
  
}
