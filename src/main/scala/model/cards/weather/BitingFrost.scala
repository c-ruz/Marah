package model.cards.weather

import model.board.Board
import model.board.row.Melee
import model.board.side.{Blue, Red}
import model.buffs.debuff.InBitingFrost
import model.cards.WeatherCard

class BitingFrost extends WeatherCard("Biting Frost") {
  override def apply(b: Board): Unit = {
    b.cards(Blue, Melee).foreach(c => c.addDebuff(InBitingFrost))
    b.cards(Red, Melee).foreach(c => c.addBuff(InBitingFrost))
  }

  override def unApply(b: Board): Unit = {
    b.cards(Blue, Melee).foreach(c => c.removeBuff(InBitingFrost))
    b.cards(Red, Melee).foreach(c => c.removeDebuff(InBitingFrost))
  }
}
