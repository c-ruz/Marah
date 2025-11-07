package model.normas

trait Norma {
  
  val value: Int
  val requiredStars: Int
  val requiredWins: Int
  
  def nextNorma: Norma
}
