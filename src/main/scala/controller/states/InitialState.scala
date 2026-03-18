package controller.states

import api.types.grid.components.Cell
import controller.GameController
import model.actions.Action
import model.actions.attack.Attack
import model.actions.equip.EquipWeapon
import model.actions.move.MoveAction
import model.entities.characters.Character

class InitialState(ctx: GameController) extends State {

  def cells: List[Cell] = ctx.allPanels.map(_.toCell)

  def menuActions(): List[Action] = {
    val base = List(new Attack, new MoveAction)
    ctx.currentTurn match {
      case _: Character => base :+ new EquipWeapon
      case _            => base
    }
  }
}
