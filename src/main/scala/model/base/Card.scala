package model.base

import model.joker.Joker
import model.rank.Rank
import model.suit.Suit


/**
 * Represents a playing card with a rank and a suit.
 *
 * A `Card` combines a `Rank` and a `Suit` to define its characteristics in a 
 * card game. The `Rank` signifies the value or order of the card, while the 
 * `Suit` represents its category or symbol.
 *
 * @constructor Creates a card with the specified rank and suit.
 * @param rank The rank of the card, indicating its value or order.
 * @param suit The suit of the card, representing its category or symbol.
 */
class Card(val rank: Rank, val suit: Suit) {

  /**
   * @return String representation of the card: $Rank.toString of $Suit.toString
   */
  override def toString: String = s"${rank.toString} of ${suit.toString}"
}
