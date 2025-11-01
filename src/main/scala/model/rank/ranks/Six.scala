package model.rank.ranks

import model.base.Score
import model.joker.Joker
import model.rank.EvenRank

/**
 * Represents the Six rank, which is an even rank in the hierarchy of ranks.
 *
 * The Six rank has a predefined order and value, and it overrides specific scoring 
 * logic inherited from its parent class `EvenRank`. The scoring logic includes 
 * the invocation of a `Joker` instance's `applySix` method before applying the 
 * superclass logic.
 *
 * @note The Six rank is part of a structured hierarchy of ranks and follows 
 *       the behavior and characteristics defined for even ranks.
 */
object Six extends EvenRank {

  /**
   * Returns the order of this rank. The order defines the specific sequencing
   * or position of the rank within a defined hierarchy or structure.
   *
   * @return the integer representing the order of this rank
   */
  override def order: Int = 6

  /**
   * Returns the value associated with this rank. The value typically represents
   * a numerical characteristic or property that differentiates this rank within
   * the hierarchy.
   *
   * @return the integer representing the value of this rank
   */
  override def value: Int = 6
}
