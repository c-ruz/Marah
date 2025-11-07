package model.normas.kinds

import model.normas.Norma

object Norma2 extends Norma {
  val value = 2
  val requiredStars = 10
  val requiredWins = 1

  override def nextNorma: Norma = Norma3
}
