package controller

import api.{ActionResult, Success}
import api.types.grid.GridGame
import api.types.grid.components.{Cell, CellEntity, ScoreView}
import controller.states.GameState
import controller.states.kinds.{
  AwaitingDiceRoll,
  AwaitingPanelChoice,
  AwaitingTurnStart,
  MovingCharacter,
  TurnEnded
}
import controller.visitor.{LandOn, PanelEffectVisitor, PassOver}
import model.actions.Action
import model.entities.PlayerCharacter
import model.maps.Tutorial
import model.panels.Panel

class GameController extends GridGame {

  // --- State Pattern ---
  private var currentState: GameState = new AwaitingTurnStart() // Initial state

  def setState(newState: GameState): Unit = {
    currentState = newState
    // Optionally, notify the View that the state (and actions) have changed
    println(s"--- New State: ${newState.getClass.getSimpleName} ---")
  }

  val players: List[PlayerCharacter] = List(
    new PlayerCharacter("Player 1", 10, 5, 5, 5),
    new PlayerCharacter("Player 2", 10, 5, 5, 5),
    new PlayerCharacter("Player 3", 10, 5, 5, 5),
    new PlayerCharacter("Player 4", 10, 5, 5, 5)
  )

  var chapter = 1
  private var _turn: Int = 0
  def turn: Int = _turn
  def turn_=(t: Int): Unit = _turn = math.max(0, math.min(t, players.size - 1))
  def currentPlayer: PlayerCharacter = players(turn)

  // moving
  var remainingMoves: Int = 0

  val map = new Tutorial(players)
  map.map(5).addEntity(players.head)
  map.map(9).addEntity(players(1))
  map.map(26).addEntity(players(2))
  map.map(30).addEntity(players(3))

  players.head.panel = Some(map.map(5))
  players(1).panel = Some(map.map(9))
  players(2).panel = Some(map.map(26))
  players(3).panel = Some(map.map(30))

  // Action Handling
  // --- Core Game Logic Methods (called by Actions/States) ---

  def startTurn(player: PlayerCharacter): Unit = {
    println(s"It's ${player.name}'s turn.")
    setState(new AwaitingDiceRoll())
  }

  def rollDice(): ActionResult = {
    val result = currentPlayer.rollDice()
    remainingMoves = result
    println(s"${currentPlayer.name} rolled a $remainingMoves")
    setState(new MovingCharacter())
    processMove() // Start the movement sequence
    Success(s"Rolled a $result")
  }

  // This is the main movement loop
  def processMove(): ActionResult = {
    // 1. Check for end of move
    if (remainingMoves == 0) {
      println(
        s"Movement finished. Landing on ${currentPlayer.panel.get.getClass.getSimpleName}."
      )
      setState(new TurnEnded())
      return PanelEffectVisitor.visit(currentPlayer.panel.get, this, LandOn)
    }

    // 2. Get next panels
    val panel = currentPlayer.panel.get
    val nextPanels = panel.nextPanels

    nextPanels.length match {
      // 3. No next panel (end of the line)
      case 0 =>
        println("End of the board.")
        remainingMoves = 0 // Force move to end
        processMove() // This will trigger the LandOn logic

      // 4. One next panel (automatic move) - REQ 1
      case 1 =>
        val nextPanel = nextPanels.head
        println(s"Moving to ${nextPanel.getClass.getSimpleName}...")

        // --- Visitor Pattern Call ---
        // Check for "pass over" effects
        PanelEffectVisitor.visit(nextPanel, this, PassOver)

        movePlayerTo(nextPanel)
        remainingMoves -= 1

        // After moving, check if the PassOver visitor added a special choice
        // (like your HomePanel example)
        if (currentState.getActions(this).nonEmpty) {
          // The visitor changed our state because a choice is available.
          // We stop processing moves and wait for user input.
          println("A choice is available!")
          Success("a")
        } else {
          // No special choice, continue the move loop
          processMove()
        }

      // 5. Multiple next panels (user choice) - REQ 1
      case _ =>
        println("Multiple paths. Please choose a panel.")
        setState(new AwaitingPanelChoice())
        Success("b")
    }
  }

  // A choice was made (from AwaitingPanelChoice)
  def chooseNextPanel(panel: Panel): Unit = {
    println(s"Player chose ${panel.getClass.getSimpleName}.")
    movePlayerTo(panel)
    remainingMoves -= 1
    setState(MovingCharacter()) // Go back to moving state
    processMove() // Continue the move loop
  }

  // Helper for moving the entity
  def movePlayerTo(panel: Panel): Unit = {
    currentPlayer.panel.get.removeEntity(currentPlayer)
    panel.removeNextPanel(currentPlayer.panel.get)
    panel.addEntity(currentPlayer)
    currentPlayer.panel = Some(panel)
  }

  /** Defines the grid to be rendered. First value defines the horizontal span
    * of the grid, second value defines the vertical span of the grid.
    */
  def gridSize: (Int, Int) = (9, 9)

  /** List of [[Cell]] to be rendered inside the grid.
    */
  def cells: List[Cell] = map.map.map(p =>
    Cell(
      label = None,
      x = p.x,
      y = p.y,
      entities = p.entities.map(e =>
        CellEntity(
          name = e.name,
          attributes = List(),
          actions = List(),
          img = Some("characters/nico.png")
        )
      ),
      actions = List(),
      img = Some(s"panels/${p.img}")
    )
  )

  /** List of [[ScoreView]] to be shown in the bottom menu.
    */
  def score: List[ScoreView] = List()

  /** Message for feedback to the user, rendered in the top bar of the
    * visualizer. Use it to provide the user with directions regarding the
    * current state of the game.
    */
  def topBarMessage: Option[String] = Some(s"Turn of ${players(turn).name}")

  /** List of [[Action]] to be shown in the bottom menu of the visualizer.
    */
  def menuActions: List[Action] = currentState.getActions(this)
}
