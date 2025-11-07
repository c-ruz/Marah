package model.normas.kinds

import model.normas.Norma

object Norma6 extends Norma {
  val value = 6
  val requiredStars = 200
  val requiredWins = 14

  override def nextNorma: Norma = Norma1
}
