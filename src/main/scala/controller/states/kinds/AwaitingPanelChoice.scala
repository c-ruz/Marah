package controller.states.kinds

import controller.GameController
import controller.states.GameState
import model.actions.{Action, ChoosePanelAction}

class AwaitingPanelChoice extends GameState {
  def getActions(c: GameController): List[Action] = {
    // Generate an action for each possible next panel
    c.currentPlayer.panel.get.nextPanels.map { panel =>
      new ChoosePanelAction(panel)
    }
  }
}
