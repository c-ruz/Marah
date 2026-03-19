package controller.states

import api.{ActionResult, Failure, Success}
import api.types.grid.components.Cell
import controller.GameController
import model.actions.Action
import model.entities.characters.Character
import model.weapons.Weapon

class SelectEquipWeapon(ctx: GameController) extends State {

  private val cancelAction: Action = new Action {
    val name: String = "Cancel"
    def doAction(c: GameController): ActionResult = {
      c.state = new InitialState(ctx)
      Success("Equip cancelled")
    }
  }

  def cells: List[Cell] = ctx.allPanels.map(_.toCell)

  def menuActions(): List[Action] = {
    val weaponActions = ctx.currentTurn match {
      case ch: Character =>
        ctx.weaponPool.map { weapon =>
          new Action {
            val name: String = weapon.name
            def doAction(c: GameController): ActionResult = {
              try {
                ch.equipWeapon(weapon)
                c.advanceTurn()
                c.state = new InitialState(ctx)
                Success(s"${ch.name} equipped ${weapon.name}!")
              } catch {
                case e: Exception => Failure(e.getMessage)
              }
            }
          }
        }
      case _ => List.empty
    }
    weaponActions :+ cancelAction
  }
}
