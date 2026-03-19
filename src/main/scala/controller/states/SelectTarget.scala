package controller.states

import api.{ActionResult, Success}
import api.types.grid.components.Cell
import controller.GameController
import model.actions.Action
import model.entities.GameEntity
import model.entities.characters.Character
import model.entities.enemies.Enemy

class SelectTarget(ctx: GameController) extends State {

  private val attacker: GameEntity = ctx.currentTurn

  // If attacker is a Character, only Enemies are valid; otherwise only Characters
  private val validTargets: Set[GameEntity] = attacker match {
    case _: Character =>
      ctx.allPanels.flatMap(_.entities).collect { case e: Enemy => e }.toSet
    case _ =>
      ctx.allPanels.flatMap(_.entities).collect { case c: Character => c }.toSet
  }

  private val cancelAction: Action = new Action {
    val name: String = "Cancel"
    def doAction(c: GameController): ActionResult = {
      c.state = new InitialState(ctx)
      Success("Attack cancelled")
    }
  }

  def cells: List[Cell] = ctx.allPanels.map { panel =>
    val base = panel.toCell
    val updatedEntities = base.entities.zip(panel.entities).map { case (cellEntity, entity) =>
      if (validTargets.contains(entity)) {
        val attackAction = new Action {
          val name: String = "Attack"
          def doAction(c: GameController): ActionResult = {
            val damage = math.max(0, attacker.attack - entity.defense)
            entity.health -= damage
            c.advanceTurn()
            c.state = new InitialState(ctx)
            Success(s"${attacker.name} attacked ${entity.name} for $damage damage!")
          }
        }
        cellEntity.copy(actions = List(attackAction))
      } else {
        cellEntity
      }
    }
    base.copy(entities = updatedEntities)
  }

  def menuActions(): List[Action] = List(cancelAction)
}
