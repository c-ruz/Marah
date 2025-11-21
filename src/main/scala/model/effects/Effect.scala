package model.effects

import model.board.Board
import model.board.side.Side
import model.cards.Card

trait Effect {
  def apply(from: Card, b: Board, s: Side): Unit
}
