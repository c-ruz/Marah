package model.normas.kinds

import model.normas.Norma

object Norma4 extends Norma {

  val value = 4
  val requiredStars = 70
  val requiredWins = 6

  override def nextNorma: Norma = Norma5
}
