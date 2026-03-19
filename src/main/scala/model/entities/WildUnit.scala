package model.entities

import scala.util.Random

abstract class WildUnit(
    val name: String,
    val maxHp: Int,
    val attack: Int,
    val defense: Int,
    val evasion: Int,
    val bonusStars: Int,
    val randomNumberGenerator: Random = new Random()
) extends PanelEntity {

  private var _hp: Int = maxHp
  def hp: Int = _hp
  def hp_=(value: Int): Unit = _hp = math.max(0, math.min(maxHp, value))

  private var _stars: Int = 0
  def stars: Int = _stars
  def stars_=(value: Int): Unit = _stars = math.max(0, value)

  def isDefeated: Boolean = _hp <= 0

  def rollDice(): Int = randomNumberGenerator.nextInt(6) + 1
}
