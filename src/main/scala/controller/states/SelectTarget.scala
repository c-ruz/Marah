package controller.states

import api.{ActionResult, Success}
import api.types.grid.components.{Cell, CellEntity}
import api.types.stack.components.StackCell
import controller.GameController
import model.actions.{Action, Target}
import model.entities.characters.Character
import model.entities.enemies.Enemy

class SelectTarget(a: Target) extends State {

  def cells: List[Cell] = List(
    Cell(None, 0, 1, List(CellEntity(name = "Enemy", attributes = List(), actions = List(
      new Action {
        val name: String = "Select Enemy"

        def doAction(c: GameController): ActionResult = {
          a.doToTarget(c, c.enemy)
          Success("Attacked Enemy")
        }
      }
      
    ), img = Some("bahamut.png"))), List(), None),
    Cell(None, 2, 0, List(CellEntity(name = "Paladin", List(), List(), Some("paladin.png"))), List(), None),
    Cell(None, 3, 1, List(CellEntity(name = "Black Mage", List(), List(), Some("black_mage.png"))), List(), None),
    Cell(None, 2, 2, List(CellEntity(name= "White Mage", List(), List(), Some("white_mage.png"))), List(), None)
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
