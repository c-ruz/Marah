package model.joker.jokers

import model.base.Score
import model.joker.{AJoker, Joker}

class DeviousJoker extends AJoker {
  override def toString: String = "Devious Joker"
  def description: String = "Adds 100 chips if hand played has a straight"
}
