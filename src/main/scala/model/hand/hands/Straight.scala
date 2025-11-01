package model.hand.hands

import model.base.{Card, Score}
import model.hand.APokerHand
import model.joker.Joker

/**
 * Represents a Straight poker hand combination.
 *
 * A `Straight` is a hand of five cards in sequential rank, regardless of their suits.
 * This class extends `APokerHand` and implements the evaluation logic to determine
 * whether a given list of cards satisfies the conditions for a Straight hand.
 *
 * This hand is scored with 30 chips and a multiplier of 4.
 */
class Straight extends APokerHand(new Score(30,4)) {

}
