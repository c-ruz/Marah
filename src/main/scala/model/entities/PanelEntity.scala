package model.entities

trait PanelEntity {
  def name: String
  def maxHp: Int
  def hp: Int
  def attack: Int
  def defense: Int
  def evasion: Int
}
