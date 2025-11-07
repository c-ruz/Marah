package controller.states

import controller.GameController
import model.actions.Action

trait GameState {
  def getActions(c: GameController): List[Action]
}