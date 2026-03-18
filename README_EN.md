# Marah

Language: EN | [ES](README.md)

## Quick Guide: Using the Marah Game Template

The system consists of two main parts:

1. Backend (Scala): HTTP API server that serves game state and handles actions
2. Frontend (React): Interactive visualizer with grid-based map, entity display, and action menus
The frontend communicates with the backend via two main endpoints:

   - GET /state - Fetches the current game state
   - POST /actions - Executes an action by its ID

### What Students Need to Implement

#### GameController Class

This is the main game logic controller. Currently it's empty and needs to contain your game state and logic.


#### Extend the corresponding abstract class for the game

- `GridGame`
  - `gridSize: (Int, Int)`—The dimensions of your grid (width, height)
  - `cells: List[Cell]`—All the cells to render in the grid 
  - `score: List[ScoreView]`—Scores/stats to display in the bottom menu 
  - `topBarMessage: Option[String]`—Instructions or feedback for the player, shown in the top bar
  - `menuActions: List[Action]`—Global actions available from the bottom menu
- `StackGame`
  - `direction: "vertical" | "horizontal"`—The direction of the stack
  - `stack: List[StackCell]`—All the cells to render in the grid
  - `score: List[ScoreView]`—Scores/stats to display in the bottom menu
  - `topBarMessage: Option[String]`—Instructions or feedback for the player, shown in the top bar
  - `menuActions: List[Action]`—Global actions available from the bottom menu


#### Create Actions

Actions represent player interactions. Each action must extend the Action trait and implement:

- `name: String`—Display name for the action button
- `doAction(c: GameController): ActionResult`—The logic to execute when clicked

Return either `Success(message)` or `Failure(message)` to provide feedback to the player.


#### Build Your Game State

Use the provided component classes to structure your game:

- **Cell**—Represents a grid position with:
  - `label: Option[String]`—Text displayed on the cell
  - `x: Int`, `y: Int`—Grid coordinates (0-indexed)
  - `entities: List[CellEntity]`—Game objects in this cell
  - `actions: List[Action]`—Actions available when clicking this cell
  - `img: Option[String]`—Background image filename (optional)

- **CellEntity**—Represents game objects (characters, items, etc.) with:
  - `name: String`—Entity name
  - `attributes: List[CellEntityAttribute]`—Properties shown in tooltip on hover
  - `actions: List[Action]`—Actions specific to this entity
  - `img: Option[String]`—Entity sprite filename (optional) CellEntity.scala:5-20
 
- **CellEntityAttribute**—Key-value pairs for entity properties (e.g., HP, Attack, Level)
  - `name: String`—Attribute name
  - `value: String`—Attribute value 

- **ScoreView**—Status information displayed in the bottom menu
  - `name: String`—Display name
  - `value: String`—Value to display

For a `StackGame`, you can use the `StackCell` class to represent a cell with a stack of items.

- **StackCell**—Represents a cell within a stack with:
    - `label: Option[String]`—Text displayed on the cell
    - `entities: List[CellEntity]`—Game objects in this cell
    - `actions: List[Action]`—Actions available when clicking this cell
    - `img: Option[String]`—Background image filename (optional)