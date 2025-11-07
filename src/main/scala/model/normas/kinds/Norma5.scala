package model.normas.kinds

import model.normas.Norma

object Norma5 extends Norma {

  val value = 5
  val requiredStars = 120
  val requiredWins = 10

  override def nextNorma: Norma = Norma6
}
