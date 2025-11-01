package model.hand.hands

import model.base.{Card, Score}
import model.hand.APokerHand
import model.joker.Joker

/**
 * Represents the Full House poker hand combination.
 *
 * A `FullHouse` is a poker hand that consists of three cards of one rank
 * and two cards of another rank. This class extends the `APokerHand` class
 * and utilizes two other poker hand combinations, `ThreeOfAKind` and `Pair`,
 * to evaluate whether a given list of cards satisfies the Full House criteria.
 *
 * This hand is scored with 40 chips and a multiplier of 4.
 *
 * @constructor Initializes the `FullHouse` with a predefined score.
 *              Combines the logic of a `ThreeOfAKind` and a `Pair` to
 *              determine if the hand is a Full House.
 */
class FullHouse extends APokerHand(new Score(40,4)) {
}
