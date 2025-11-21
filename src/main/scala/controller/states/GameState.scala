package controller.states

import controller.GameController
import model.actions.Action

abstract class GameState extends State {
  override def play(c: GameController, index: Int): Unit = {
    throw new IllegalStateException("This state does not support playing cards")
  }

  override def pass(c: GameController): Unit = {
    throw new IllegalStateException("This state does not support passing")
  }

  override def getAvailableActions(c: GameController): List[Action] = List()
}
