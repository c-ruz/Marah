package model.panels

import controller.GameController
import model.actions.Action
import model.entities.PanelEntity

abstract class AbsPanel(val x: Int, val y: Int) extends Panel {

  private var _entities: Seq[PanelEntity] = Seq()
  override def entities: List[PanelEntity] = _entities.toList

  override def addEntity(e: PanelEntity): Unit =
    _entities = _entities :+ e

  override def removeEntity(e: PanelEntity): Unit = _entities =
    _entities.filterNot(_ == e)

  private var _nextPanels: Seq[Panel] = Seq()
  override def nextPanels: List[Panel] = _nextPanels.toList

  override def addNextPanel(p: Panel): Unit =
    _nextPanels = _nextPanels :+ p

  override def removeNextPanel(p: Panel): Unit =
    _nextPanels = _nextPanels.filterNot(_ == p)
}
