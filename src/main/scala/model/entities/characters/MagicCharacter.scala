package model.entities.characters

abstract class MagicCharacter(
                               name: String,
                               defense: Int,
                               weight: Int,
                               health: Int,
                               val mana: Int,
                               img: Option[String]
                             ) extends CommonCharacter(name, defense, weight, health, img) {

  private var currentMana: Int = mana
  def mana_=(newMana: Int): Unit = currentMana = newMana
}
