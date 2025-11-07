package controller.states.kinds

import controller.GameController
import controller.states.GameState
import model.actions.{Action, RollDiceAction}

class AwaitingDiceRoll extends GameState {
  def getActions(c: GameController): List[Action] = {
    List(new RollDiceAction())
  }
}
