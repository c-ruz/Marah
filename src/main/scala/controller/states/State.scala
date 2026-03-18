package controller.states

import api.types.grid.components.Cell
import model.actions.Action

trait State {
  def cells: List[Cell]
  def menuActions(): List[Action]
}
