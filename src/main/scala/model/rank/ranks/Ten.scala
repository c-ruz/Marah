package model.rank.ranks

import model.base.Score
import model.joker.Joker
import model.rank.EvenRank

/**
 * Represents the Ten rank, categorized under the hierarchy of even ranks.
 *
 * The Ten rank has a predefined order and value, distinguishing it within
 * the rank hierarchy. This class extends the `EvenRank` abstract base class,
 * adhering to the defined behavior and properties shared by all even ranks.
 *
 * @note The Ten rank is part of the structured hierarchy of ranks and
 *       shares characteristics with other even ranks.
 */
object Ten extends EvenRank {

  /**
   * Returns the order of this rank. The order defines the specific sequencing
   * or position of the rank within a defined hierarchy or structure.
   *
   * @return the integer representing the order of this rank
   */
  override def order: Int = 10

  /**
   * Returns the value associated with this rank. The value typically represents
   * a numerical characteristic or property that differentiates this rank within
   * the hierarchy.
   *
   * @return the integer representing the value of this rank
   */
  override def value: Int = 10
}
