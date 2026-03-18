package model.panels

import model.entities.GameEntity

/** Concrete implementation of [[Panel]].
 *
 * @param x horizontal coordinate on the game grid
 * @param y vertical coordinate on the game grid
 */
class ConcretePanel(val x: Int, val y: Int) extends Panel {

  private var _entities: List[GameEntity] = List.empty
  private var _adjacentPanels: List[Panel] = List.empty

  def entities: List[GameEntity] = _entities

  def addEntity(entity: GameEntity): Unit =
    _entities = _entities :+ entity

  def removeEntity(entity: GameEntity): Unit =
    _entities = _entities.filterNot(_ eq entity)

  def adjacentPanels: List[Panel] = _adjacentPanels

  def addAdjacentPanel(panel: Panel): Unit =
    _adjacentPanels = _adjacentPanels :+ panel
}
