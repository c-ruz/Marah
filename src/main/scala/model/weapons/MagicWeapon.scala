package model.weapons

abstract class MagicWeapon(
                          name: String,
                          attack: Int,
                          val magicAttack: Int,
                          weight: Int
                          ) extends CommonWeapon(name, attack, weight) {
}
