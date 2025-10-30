package model.turns

import model.entities.GameEntity

class TurnScheduler(private val entities: List[GameEntity]) {

  def nextTurn(): GameEntity = {
    var candidates = entities.filter(e => e.currentActionBar >= e.weight)
    while candidates.isEmpty do {
      entities.foreach(e => e.currentActionBar = e.currentActionBar + 1)
      candidates = entities.filter(e => e.currentActionBar >= e.weight)
    }

    // Get the entity with the highest surplus of action bar
    candidates.maxBy(e => e.currentActionBar - e.weight)
  }
}
