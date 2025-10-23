package api.types.base.stack

import api.types.base.grid.GridGame

abstract class StackGame extends GridGame {
  
  /**
   * Defines the direction the cells will be rendered.
   * It can be either "vertical" or "horizontal"
   */ 
  def direction: "vertical" | "horizontal"

  def gridSize: (Int, Int) = direction match {
    case "vertical" => (1, cells.length)
    case "horizontal" => (cells.length, 1)
  }
}
