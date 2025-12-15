package controller.states

import api.types.grid.components.Cell
import api.types.stack.components.StackCell
import controller.GameController
import model.actions.Action
import model.entities.enemies.Enemy
import model.entities.characters.Character

trait State {
  def cells: List[Cell]
  def menuActions(): List[Action]
}
