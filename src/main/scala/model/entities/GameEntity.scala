package model.entities

trait GameEntity {
  
  def name: String

  def attack: Int

  def defense: Int

  def health: Int
  
  def health_=(newHealth: Int): Unit
  
  def currentHealth: Int
  
  def weight: Int
  
  def currentActionBar: Int
  def currentActionBar_=(newAB: Int): Unit
  def actionBarString: String
  
  def img: Option[String]
  
}
