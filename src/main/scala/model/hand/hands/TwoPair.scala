package model.hand.hands

import model.base.{Card, Score}
import model.hand.APokerHand
import model.joker.Joker

/**
 * Represents the Two Pair poker hand combination.
 *
 * A `TwoPair` consists of two distinct pairs of cards with the same rank.
 * This class extends `APokerHand` and implements the logic to evaluate if
 * a given list of cards satisfies the conditions for a Two Pair poker hand.
 *
 * This hand is scored with 20 chips and a multiplier of 2.
 */
class TwoPair extends APokerHand(new Score(20,2)) {

}
