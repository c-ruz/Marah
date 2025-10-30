package controller.states

import api.types.stack.components.StackCell
import controller.GameController
import model.actions.Action
import model.entities.enemies.Enemy
import model.entities.characters.Character

trait State {
  def cells(enemies: List[Enemy], characters: List[Character]): List[StackCell]
  def menuActions(): List[Action]
}
