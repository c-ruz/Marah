package model.normas.kinds

import model.normas.Norma

object Norma1 extends Norma {
  val value = 1
  val requiredStars = 0
  val requiredWins = 0

  override def nextNorma: Norma = {
    Norma2
  }
}
