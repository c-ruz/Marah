package model.panels

import controller.GameController
import model.entities.PanelEntity

trait Panel {
  val x: Int
  val y: Int
  val img: String

  def entities: List[PanelEntity]

  def nextPanels: List[Panel]

  def addEntity(e: PanelEntity): Unit

  def removeEntity(e: PanelEntity): Unit

  def addNextPanel(p: Panel): Unit

  def removeNextPanel(p: Panel): Unit
}
