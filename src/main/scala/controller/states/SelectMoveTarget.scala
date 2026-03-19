package controller.states

import api.{ActionResult, Success}
import api.types.grid.components.Cell
import controller.GameController
import model.actions.Action
import model.panels.Panel

class SelectMoveTarget(ctx: GameController) extends State {

  // Resolved once at snapshot time — same instances used by findActionById
  private val currentPanel: Option[Panel] =
    ctx.allPanels.find(_.entities.exists(_ eq ctx.currentTurn))

  private val adjacent: Set[Panel] =
    currentPanel.map(_.adjacentPanels.toSet).getOrElse(Set.empty)

  private val cancelAction: Action = new Action {
    val name: String = "Cancel"
    def doAction(c: GameController): ActionResult = {
      c.state = new InitialState(ctx)
      Success("Move cancelled")
    }
  }

  def cells: List[Cell] = ctx.allPanels.map { panel =>
    val base = panel.toCell
    if (adjacent.contains(panel)) {
      val moveHere = new Action {
        val name: String = "Move here"
        def doAction(c: GameController): ActionResult = {
          val mover = ctx.currentTurn
          currentPanel.foreach(_.moveEntity(mover, panel))
          c.advanceTurn()
          c.state = new InitialState(ctx)
          Success(s"${mover.name} moved to (${panel.x}, ${panel.y})")
        }
      }
      base.copy(actions = List(moveHere))
    } else {
      base
    }
  }

  def menuActions(): List[Action] = List(cancelAction)
}
