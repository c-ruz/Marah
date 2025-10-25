package model.entities

trait GameEntity {
  
  def name: String

  def attack: Int

  def defense: Int

  def health: Int
  
  def currentHealth: Int
  
  def weight: Int
  
  def img: Option[String]
}
