package controller.visitor

sealed trait PanelEvent
case object LandOn extends PanelEvent   // For when moves = 0
case object PassOver extends PanelEvent // For passing through
