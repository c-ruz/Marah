package controller.states.kinds

import controller.GameController
import controller.states.GameState
import model.actions.{Action, StartTurnAction}

class AwaitingTurnStart extends GameState {
  def getActions(c: GameController): List[Action] = {
    List(new StartTurnAction(c.currentPlayer))
  }
}
