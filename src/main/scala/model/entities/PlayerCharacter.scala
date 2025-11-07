package model.entities

import model.normas.Norma
import model.normas.kinds.Norma1
import model.panels.Panel

import scala.util.Random

class PlayerCharacter(
    val name: String,
    val maxHp: Int,
    val attack: Int,
    val defense: Int,
    val evasion: Int,
    val randomNumberGenerator: Random = new Random()
) extends PanelEntity {
  private var _hp: Int = maxHp
  def hp: Int = _hp
  def hp_=(value: Int): Unit = _hp = math.max(0, math.min(maxHp, value))

  private var _stars = 0
  def stars: Int = _stars
  def stars_=(value: Int): Unit = _stars = math.max(0, value)
  
  private var _wins = 0
  def wins: Int = _wins
  def wins_=(value: Int): Unit = _wins = math.max(0, value)
  
  private var _norma: Norma = Norma1
  def norma: Norma = _norma
  def advanceNorma(): Unit = _norma = _norma.nextNorma
  
  private var _panel: Option[Panel] = None
  def panel: Option[Panel] = _panel
  def panel_=(value: Option[Panel]): Unit = _panel = value
  
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }
}
