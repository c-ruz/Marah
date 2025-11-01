package model.joker

import model.base.Score

/**
 * Represents logic for applying scores based on various factors in a card game.
 *
 * The `Joker` trait provides methods to modify the scoring system of a card game
 * by applying different scoring rules based on suits, hand combinations, ranks,
 * and other characteristics. Each method takes a `Score` object as input,
 * applies a specific transformation, and returns an updated `Score` object.
 */
trait Joker {
  def description: String
}
