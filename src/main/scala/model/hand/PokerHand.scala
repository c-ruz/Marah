package model.hand

import model.base.{Card, Score}
import model.joker.Joker

/**
 * Represents a poker hand in a card game.
 *
 * This trait encapsulates the behavior and properties required to evaluate
 * and score a poker hand based on a collection of cards. Implementations
 * should define the rules for determining whether a given set of cards
 * constitutes a valid hand and calculate the score for that hand.
 */
trait PokerHand {

  /**
   * Computes and returns the score of the current poker hand.
   *
   * This method evaluates the poker hand according to specific rules and
   * scoring criteria, returning a `Score` object that encapsulates the
   * chips and multiplier values associated with the hand's performance.
   *
   * @return the `Score` object representing the evaluated score of the poker hand
   */
  def score: Score
}
