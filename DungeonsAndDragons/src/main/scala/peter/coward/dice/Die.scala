package peter.coward.dice

sealed trait DiceType

case object DFour extends DiceType
case object DSix extends DiceType
case object DEight extends DiceType
case object DTen extends DiceType
case object DTwelve extends DiceType
case object DTwenty extends DiceType
case object DPercentile extends DiceType
