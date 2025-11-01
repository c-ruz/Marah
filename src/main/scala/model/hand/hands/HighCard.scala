package model.hand.hands

import model.base.{Card, Score}
import model.hand.APokerHand
import model.joker.Joker

/**
 * Represents the High Card poker hand combination.
 *
 * A `HighCard` is the lowest ranking poker hand, defined as any hand that does 
 * not qualify for any other poker hand combinations such as Pair, Flush, or Full House.
 * This class extends `APokerHand` and always evaluates to `true` since every valid hand
 * can qualify as a High Card if no other specific combination is met.
 *
 * This hand is scored with 5 chips and a multiplier of 1.
 */
class HighCard extends APokerHand(new Score(5,1)) {

}
