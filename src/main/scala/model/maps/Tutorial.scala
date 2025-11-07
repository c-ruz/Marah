package model.maps

import model.entities.PlayerCharacter
import model.panels.Panel
import model.panels.kinds.*

class Tutorial(players: List[PlayerCharacter]) {
  val map: List[Panel] = List(
    new BonusPanel(0, 3),
    new NeutralPanel(0, 4),
    new EncounterPanel(0, 5),
    new NeutralPanel(1, 3),
    new BonusPanel(1, 5),
    new HomePanel(players.head, 2, 2),
    new DropPanel(2, 3),
    new BonusPanel(2, 4),
    new NeutralPanel(2, 5),
    new HomePanel(players(1), 2, 6),
    new DropPanel(3, 0),
    new NeutralPanel(3, 1),
    new BonusPanel(3, 2),
    new EncounterPanel(3, 6),
    new NeutralPanel(3, 7),
    new BonusPanel(3, 8),
    new NeutralPanel(4, 0),
    new NeutralPanel(4, 2),
    new NeutralPanel(4, 6),
    new NeutralPanel(4, 8),
    new BonusPanel(5, 0),
    new NeutralPanel(5, 1),
    new EncounterPanel(5, 2),
    new BonusPanel(5, 6),
    new NeutralPanel(5, 7),
    new DropPanel(5, 8),
    new HomePanel(players(2), 6, 2),
    new NeutralPanel(6, 3),
    new BonusPanel(6, 4),
    new EncounterPanel(6, 5),
    new HomePanel(players(3), 6, 6),
    new BonusPanel(7, 3),
    new NeutralPanel(7, 5),
    new DropPanel(8, 3),
    new NeutralPanel(8, 4),
    new BonusPanel(8, 5)
  )
  
  def connectMap(): Unit = {
    map.foreach { panel =>
      // Find adjacent panels (1 unit away horizontally or vertically)
      val adjacent = map.filter { other =>
        (panel != other) && (
          (math.abs(
            panel.x - other.x
          ) == 1 && panel.y == other.y) || // horizontal neighbor
            (math.abs(
              panel.y - other.y
            ) == 1 && panel.x == other.x) // vertical neighbor
          )
      }
      // Add each adjacent panel as a next panel
      adjacent.foreach(panel.addNextPanel)
    } 
  }
  
  connectMap()
}
