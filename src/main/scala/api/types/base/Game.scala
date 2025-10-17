package api.types.base

import api.types.components.ScoreView
import model.actions.Action

trait Game {

  /** List of [[ScoreView]] to be shown in the bottom menu.
    */
  var score: List[ScoreView]

  /** Message for feedback to the user, rendered in the top bar of the
    * visualizer. Use it to provide the user with directions regarding the
    * current state of the game.
    */
  var topBarMessage: Option[String]

  /** List of [[Action]] to be shown in the bottom menu of the visualizer.
    */
  var menuActions: List[Action]
  
  def findActionById(id: String): Option[Action]
}
