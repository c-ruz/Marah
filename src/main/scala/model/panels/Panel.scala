package model.panels

import api.types.grid.components.{Cell, CellEntity, CellEntityAttribute}
import model.entities.GameEntity

/** Represents a panel (tile) on the game board.
 *
 * A Panel holds [[GameEntity]] objects and knows its neighbours.
 * An entity can move exactly one step to any adjacent panel.
 */
trait Panel {

  def x: Int
  def y: Int

  /** All entities currently standing on this panel. */
  def entities: List[GameEntity]

  /** Add an entity to this panel. */
  def addEntity(entity: GameEntity): Unit

  /** Remove an entity from this panel. */
  def removeEntity(entity: GameEntity): Unit

  /** Panels reachable in one step from this panel. */
  def adjacentPanels: List[Panel]

  /** Register a panel as adjacent (one-directional). */
  def addAdjacentPanel(panel: Panel): Unit

  /** Move an entity from this panel to an adjacent one.
   *
   * @return true if the move succeeded, false if the target is not adjacent
   *         or the entity is not on this panel.
   */
  def moveEntity(entity: GameEntity, target: Panel): Boolean = {
    if (adjacentPanels.contains(target) && entities.contains(entity)) {
      removeEntity(entity)
      target.addEntity(entity)
      true
    } else {
      false
    }
  }

  /** Converts this panel to a [[Cell]] for the visualization framework. */
  def toCell: Cell = Cell(
    x = x,
    y = y,
    entities = entities.map { e =>
      CellEntity(
        name = e.name,
        img  = e.img,
        attributes = List(
          CellEntityAttribute("HP", s"${e.currentHealth}/${e.health}"),
          CellEntityAttribute("ATK", e.attack.toString),
          CellEntityAttribute("DEF", e.defense.toString)
        )
      )
    }
  )
}