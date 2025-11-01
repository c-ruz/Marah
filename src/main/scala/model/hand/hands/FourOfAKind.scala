package model.hand.hands

import model.base.{Card, Score}
import model.hand.APokerHand
import model.joker.Joker

/**
 * Represents the Four of a Kind poker hand combination.
 *
 * A `FourOfAKind` is a poker hand where at least four cards have the same rank.
 * This class extends `APokerHand` and implements the logic to determine
 * whether a given list of cards satisfies the conditions for a Four of a Kind.
 *
 * @constructor Initializes a `FourOfAKind` instance with a predefined score.
 */
class FourOfAKind extends APokerHand(new Score(60,7)){

}
