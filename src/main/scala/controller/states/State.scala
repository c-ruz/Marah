package controller.states

import controller.GameController
import model.actions.Action

trait State {

  def play(c: GameController, index: Int): Unit

  def pass(c: GameController): Unit
  
  def getAvailableActions(c: GameController): List[Action]
}
