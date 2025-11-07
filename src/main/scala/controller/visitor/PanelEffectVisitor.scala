package controller.visitor

import api.{ActionResult, Success}
import controller.GameController
import controller.states.kinds.AwaitingCustomChoice
import model.actions.{ContinueMovingAction, StopOnPanelAction}
import model.panels.Panel
import model.panels.kinds.*

object PanelEffectVisitor {

  def visit(
      panel: Panel,
      controller: GameController,
      event: PanelEvent
  ): ActionResult = {
    val player = controller.currentPlayer

    // too lazy to do actual visitor pattern
    (panel, event) match {
      // --- HomePanel Example ---
      case (hp: HomePanel, PassOver) =>
        println("...passing over a HomePanel")
        // Your special logic: owner can stop
        if (hp.isOwner(player)) {
          println("It's your HomePanel! You can choose to stop.")

          // We also pass the *remaining moves* to the continue action
          val stopAction = new StopOnPanelAction(hp)
          val continueAction = new ContinueMovingAction(controller.remainingMoves)

          // We create a *new* temporary state to hold these custom actions
          controller.setState(
            new AwaitingCustomChoice(List(stopAction, continueAction))
          )
          Success("You can stop or continue moving.")
        }
        Success("No effect.")
      case (bonusPanel: BonusPanel, LandOn) =>
        println("...landing on a BonusPanel.")
        val dice = controller.currentPlayer.rollDice()
        controller.currentPlayer.stars = controller.currentPlayer.stars + math.min(dice * controller.currentPlayer.norma.value, dice * 3)
        Success("You got " + dice + " dice. You got " + controller.currentPlayer.stars + " stars.") 
        
      // Default case: Do nothing
      case _ =>
      println("...passing over a basic panel. No effect.")
      Success("No effect.")
    }
  }
}
