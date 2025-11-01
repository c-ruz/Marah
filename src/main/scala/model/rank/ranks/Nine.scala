package model.rank.ranks

import model.base.Score
import model.joker.Joker
import model.rank.OddRank

/**
 * Represents the rank with the ordinal order and value of nine, categorized under 
 * the hierarchy of odd ranks. This class is a concrete implementation of the 
 * `OddRank` abstract base class, defining a rank that is odd-valued and possesses 
 * a unique position within the rank hierarchy.
 */
object Nine extends OddRank {

  /**
   * Returns the order of this rank. The order defines the specific sequencing
   * or position of the rank within a defined hierarchy or structure.
   *
   * @return the integer representing the order of this rank
   */
  override def order: Int = 9

  /**
   * Returns the value associated with this rank. The value typically represents
   * a numerical characteristic or property that differentiates this rank within
   * the hierarchy.
   *
   * @return the integer representing the value of this rank
   */
  override def value: Int = 9
}
