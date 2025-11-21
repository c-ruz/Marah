package model.cards

import api.types.grid.components.CellEntityAttribute
import model.board.side.Side
import model.board.Board
import model.buffs.Condition
import model.effects.Effect

trait Card:
  def id: String
  def name: String
  def play(b: Board, s: Side): Unit
  def attributes: List[CellEntityAttribute]
