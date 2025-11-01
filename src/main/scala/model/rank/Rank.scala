package model.rank

import model.base.Score
import model.joker.Joker


/**
 * A trait representing a rank with a defined order and value. This hierarchy 
 * enables structuring and distinguishing between various types of ranks. 
 * Typically extended by specific rank types such as OddRank, EvenRank, and 
 * FaceRank.
 */
trait Rank {
  
  
  /**
   * Returns the order of this rank. The order defines the specific sequencing 
   * or position of the rank within a defined hierarchy or structure.
   *
   * @return the integer representing the order of this rank
   */
  def order: Int
  
  
  /**
   * Returns the value associated with this rank. The value typically represents
   * a numerical characteristic or property that differentiates this rank within 
   * the hierarchy.
   *
   * @return the integer representing the value of this rank
   */
  def value: Int

  /**
   * Returns the string representation of this rank.
   *
   * This method provides the simple name of the class associated with the rank,
   * which typically represents its type or category.
   *
   * @return the simple name of the class as a string
   */
  override def toString: String = this.getClass.getSimpleName.filter(_ != '$')
}
