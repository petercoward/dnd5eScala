package peter.coward.spec

import org.scalatest.{FlatSpec, Matchers}
import peter.coward.dice._

class DiceSpec extends FlatSpec with Matchers{

  "DiceRoller" should "roll different dice and return a correct result" in {

    val testData = List(
      (DFour, 1 to 4),
      (DSix, 1 to 6),
      (DEight, 1 to 8),
      (DTen, 1 to 10),
      (DTwelve, 1 to 12),
      (DTwenty, 1 to 20),
      (DPercentile, 1 to 100)
    )

    val roller = new DiceRoller()

    testData.foreach {
      case (dice, range) =>
        val result = roller.roll(dice)
        range should contain (result)
    }

  }

}
