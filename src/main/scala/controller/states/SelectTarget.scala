package controller.states

import api.{ActionResult, Success}
import api.types.grid.components.CellEntity
import api.types.stack.components.StackCell
import controller.GameController
import model.actions.Action
import model.entities.characters.Character
import model.entities.enemies.Enemy

class SelectTarget extends State {

  def cells(enemies: List[Enemy], characters: List[Character]): List[StackCell] = List(
    StackCell(
      Some("Enemies"),
      enemies.map(e => CellEntity(e.name, List(), List(), None)),  
      List(), None),
    StackCell(Some("Characters"),
      characters.map(c => CellEntity(c.name, List(), List(), None)), 
      List(), None)
  )

  def menuActions(): List[Action] = List(
    new Action {
      val name: String = "Cancel"

      def doAction(c: GameController): ActionResult = {
        c.state = new InitialState
        Success("Canceled")
      }
    }
  )
}
