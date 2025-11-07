package controller.states.kinds

import controller.GameController
import controller.states.GameState
import model.actions.Action

class MovingCharacter extends GameState {
  def getActions(c: GameController): List[Action] = List()
}
