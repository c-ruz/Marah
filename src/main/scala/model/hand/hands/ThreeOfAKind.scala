package model.hand.hands

import model.base.{Card, Score}
import model.hand.APokerHand
import model.joker.Joker

/**
 * Represents the Three of a Kind poker hand combination.
 *
 * A `ThreeOfAKind` is a poker hand where exactly three cards have the same rank.
 * This class extends `APokerHand` and implements the logic to determine
 * whether a given list of cards satisfies the conditions for a Three of a Kind.
 *
 * This hand is scored with 30 chips and a multiplier of 3.
 */
class ThreeOfAKind extends APokerHand(new Score(30,3)) {
  
}
