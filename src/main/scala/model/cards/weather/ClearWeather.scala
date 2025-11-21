package model.cards.weather

import model.board.Board
import model.cards.WeatherCard

class ClearWeather extends WeatherCard("Clear Weather") {

  override def apply(b: Board): Unit = {}

  override def unApply(b: Board): Unit = {}
}
