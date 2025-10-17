package api.types.base

import api.types.components.Cell
import model.actions.Action

abstract class GridGame extends Game {

  /** Defines the grid to be rendered. First value defines the horizontal span
    * of the grid, second value defines the vertical span of the grid.
    */
  var gridSize: (Int, Int)

  /** List of [[Cell]] to be rendered inside the grid.
    */
  var cells: List[Cell]

  override def findActionById(id: String): Option[Action] =
    (menuActions ++ cells.flatMap(_.actions) ++ cells.flatMap(
      _.entities.flatMap(_.actions)
    )).find(_.id == id)
}
