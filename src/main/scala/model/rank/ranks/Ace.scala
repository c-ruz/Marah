package model.rank.ranks

import model.base.Score
import model.joker.Joker
import model.rank.OddRank

/**
 * Represents the Ace rank, which is a special odd rank in a hierarchy of ranks.
 *
 * The Ace rank has a predefined order and value, and it overrides specific 
 * scoring logic inherited from its parent class `OddRank`. The scoring logic 
 * includes the invocation of a `Joker` instance's `applyAce` method before 
 * applying the superclass logic.
 *
 * @note The Ace rank is considered unique, both in its scoring behavior and 
 *       its position within the rank hierarchy.
 */
object Ace extends OddRank {
  /**
   * Returns the order of this rank. The order defines the specific sequencing
   * or position of the rank within a defined hierarchy or structure.
   *
   * @return the integer representing the order of this rank
   */
  override def order: Int = 14

  /**
   * Returns the value associated with this rank. The value typically represents
   * a numerical characteristic or property that differentiates this rank within
   * the hierarchy.
   *
   * @return the integer representing the value of this rank
   */
  override def value: Int = 11
}
