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

    (panel, event) match {

      // --- HomePanel ---
      case (hp: HomePanel, PassOver) =>
        println("...passing over a HomePanel")
        if (hp.isOwner(player)) {
          println("It's your HomePanel! You can choose to stop.")
          val stopAction = new StopOnPanelAction(hp)
          val continueAction = new ContinueMovingAction(controller.remainingMoves)
          controller.setState(new AwaitingCustomChoice(List(stopAction, continueAction)))
          Success("You can stop or continue moving.")
        } else {
          Success("No effect.")
        }

      case (hp: HomePanel, LandOn) =>
        println("...landing on a HomePanel.")
        player.hp = player.hp + 1
        val normaMsg = controller.normaCheck(player)
        Success(s"+1 HP. $normaMsg")

      // --- BonusPanel ---
      case (_: BonusPanel, LandOn) =>
        println("...landing on a BonusPanel.")
        val dice = player.rollDice()
        val gained = math.min(dice * player.norma.value, dice * 3)
        player.stars += gained
        Success(s"Rolled $dice. Gained $gained stars. Total: ${player.stars}")

      // --- DropPanel ---
      case (_: DropPanel, LandOn) =>
        println("...landing on a DropPanel.")
        val dice = player.rollDice()
        val lost = dice * player.norma.value
        player.stars -= lost
        Success(s"Rolled $dice. Lost $lost stars. Total: ${player.stars}")

      // --- EncounterPanel ---
      case (ep: EncounterPanel, LandOn) =>
        println("...landing on an EncounterPanel.")
        val wildUnit = ep.wildUnit
        println(s"Encountered a ${wildUnit.name}!")
        val combatLog = controller.performCombat(player, wildUnit)
        ep.respawnIfDefeated()
        println(combatLog)
        Success(s"Combat with ${wildUnit.name}.\n$combatLog")

      // --- Default: No effect ---
      case _ =>
        println("...passing over a basic panel. No effect.")
        Success("No effect.")
    }
  }
}
