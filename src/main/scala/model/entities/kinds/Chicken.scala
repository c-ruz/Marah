package model.entities.kinds

import model.entities.WildUnit

class Chicken extends WildUnit(
  name = "Chicken",
  maxHp = 3,
  attack = -1,
  defense = -1,
  evasion = 1,
  bonusStars = 3
)
