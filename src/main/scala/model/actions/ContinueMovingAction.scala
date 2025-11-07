package model.actions

import api.{ActionResult, Success}
import controller.GameController
import controller.states.kinds.MovingCharacter

class ContinueMovingAction(movesLeft: Int) extends Action {
  val name: String = s"Continue Moving ($movesLeft moves left)"
  def doAction(c: GameController): ActionResult = {
    println("Player chose to continue moving.")
    c.setState(MovingCharacter())
    c.processMove() // Continue the move loop
    Success("Moving...")
  }
}
