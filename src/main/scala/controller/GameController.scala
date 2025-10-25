package controller

import api.types.grid.components.{CellEntity, CellEntityAttribute, ScoreView}
import api.types.stack.StackGame
import api.types.stack.components.StackCell
import controller.states.{InitialState, State}
import model.actions.Action
import model.entities.enemies.Enemy
import model.entities.characters.{BlackMage, Character, Paladin, WhiteMage}

class GameController extends StackGame {

  private var state: State = new InitialState()

  private var enemies: List[Enemy] = List(
    new Enemy("Enemy 1", 100, 10, 10, 10, Some("bahamut.png"))
  )
  private var characters: List[Character] = List(new Paladin, new WhiteMage, new BlackMage)

  /**
   * Defines the direction the cells will be rendered.
   * It can be either "vertical" or "horizontal"
   */
  def direction: "vertical" | "horizontal" = "horizontal"

  def stack: List[StackCell] = List(
    StackCell(
      label = Some("Enemies"), entities = enemies.map(
        e => CellEntity(e.name, List(
          CellEntityAttribute(name = "HP", value = s"${e.currentHealth} / ${e.health}"),
          CellEntityAttribute(name = "ATK", value = e.attack.toString),
          CellEntityAttribute(name = "DEF", value = e.defense.toString)
        ), List(), e.img)
      ), actions = List(), img = None
    ),
    StackCell(
      label = Some("Characters"), entities = characters.map(
        e => CellEntity(e.name, List(
          CellEntityAttribute(name = "HP", value = s"${e.currentHealth} / ${e.health}"),
          CellEntityAttribute(name = "ATK", value = e.attack.toString),
          CellEntityAttribute(name = "DEF", value = e.defense.toString),
          CellEntityAttribute(name = "Weapon", value = e.weapon.map(_.name).getOrElse("No weapon equipped"))
        ), List(), e.img)
      ), actions = List(), img = None
    )
  )
  /** List of [[ScoreView]] to be shown in the bottom menu.
   */
  def score: List[ScoreView] = List()

  /** Message for feedback to the user, rendered in the top bar of the
   * visualizer. Use it to provide the user with directions regarding the
   * current state of the game.
   */
  def topBarMessage: Option[String] = Some("Welcome to the game!")

  /** List of [[Action]] to be shown in the bottom menu of the visualizer.
   */
  def menuActions: List[Action] = List()
}
