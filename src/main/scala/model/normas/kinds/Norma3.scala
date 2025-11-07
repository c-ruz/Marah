package model.normas.kinds

import model.normas.Norma

object Norma3 extends Norma {
  val value = 3
  val requiredStars = 30
  val requiredWins = 3

  override def nextNorma: Norma = Norma4
}
