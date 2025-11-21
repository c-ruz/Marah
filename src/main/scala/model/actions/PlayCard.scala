package model.actions

import controller.GameController

class PlayCard(val index: Int) extends Action {
  val name: String = s"Play Card/$index"
  override def doAction(c: GameController): String = {
    val player = c.currentPlayer
    c.play(index)
    s"${player.name} played card at index $index."
  }
}