package peter.coward.dice



class DiceRoller(seed: Int = 0) {

  private val rand = new scala.util.Random(seed)

  def roll(diceType: DiceType): Int = {
    diceType match {
      case DFour => rollD4()
      case DSix => rollD6()
      case DEight => rollD8()
      case DTen => rollD10()
      case DTwelve => rollD12()
      case DTwenty => rollD4()
      case DPercentile => rollD4()
    }
  }
  //Map through list and accumulate total
  //TODO: test this
  def rollMultiple(diceList: List[DiceType]): Int = diceList.foldLeft(0)((acc, dt) => acc + roll(dt))

  def rollAdvantage(diceType: DiceType): Int = {
    val firstRoll = roll(diceType)
    val secondRoll = roll(diceType)

    if(firstRoll >= secondRoll)
      firstRoll
    else
      secondRoll
  }

  def rollDisadvantage(diceType: DiceType): Int = {
    val firstRoll = roll(diceType)
    val secondRoll = roll(diceType)

    if(firstRoll <= secondRoll)
      firstRoll
    else
      secondRoll
  }

  private def rollD4(): Int = rand.nextInt(4) + 1
  private def rollD6(): Int = rand.nextInt(6) + 1
  private def rollD8(): Int = rand.nextInt(8) + 1
  private def rollD10(): Int = rand.nextInt(10) + 1
  private def rollD12(): Int = rand.nextInt(12) + 1
  private def rollD20(): Int = rand.nextInt(20) + 1
  private def rollDPercentile(): Int = rand.nextInt(100) + 1
}
