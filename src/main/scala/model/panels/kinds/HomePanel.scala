package model.panels.kinds

import controller.GameController
import model.actions.Action
import model.entities.PlayerCharacter
import model.panels.AbsPanel

class HomePanel(owner: PlayerCharacter, x: Int, y: Int) extends AbsPanel(x,y) {
  
  val img = "home.png"

  def isOwner(p: PlayerCharacter): Boolean =
    p == owner
  
}
