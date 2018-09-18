package peter.coward.spec

import peter.coward.character.Character

import org.scalatest.{FlatSpec, Matchers}

class CharacterSpec extends FlatSpec with Matchers {

  "Character object function calculateProficiencyBonus" should "return the correct prof bonus" in {
    Character.calculateProficiencyBonus(3) shouldBe 2
  }

}
