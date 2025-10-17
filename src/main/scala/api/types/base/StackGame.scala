package api.types.base

abstract class StackGame extends GridGame {
  
  /**
   * Defines the direction the cells will be rendered.
   * It can be either "vertical" or "horizontal"
   */ 
  val direction: "vertical" | "horizontal"

  var gridSize: (Int, Int) = (1,1)
}
