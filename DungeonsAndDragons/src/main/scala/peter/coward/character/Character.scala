package peter.coward.character

import scala.math.floor

class Character(
                 name: String,
                 cls: String,
                 align: String,
                 lvl: Int = 1,
                 attr: Map[String, Attribute],
                 svThrows: Map[String, Int],
                 skls: List[Proficiency],
                 mny: Money = Money(0,0,0,0,0),
                 cmbtMods: CombatModifiers,
                 sklMods: ProficiencyModifiers
               ) {

  protected val `class` = cls
  protected val level = lvl
  protected val charaterName = name
  protected val alignment = align

  val combatModifiers: CombatModifiers = cmbtMods

  val money: Money = mny

  protected val attributes: Map[String, Attribute] = attr
  protected val savingThrows: Map[String, Int] = svThrows
  protected val skills: List[Proficiency] = skls

  def getPassiveWisdomPerception(): Int = ??? //10 + Wisdom(Perception)

  def updateAttribute(attrName: String, newValue: Int) = {
    attributes.updated(attrName, Character.calculateAttributeModifier(newValue))
  }

}

object Character {
  /*
  def apply(level: Int, attributes: Map[String, Int], armourClass: Int, initiative: Int, speed:Int, hp: Int): Character = {
    val cmbtMods = CombatModifiers(armourClass, initiative, speed, hp)
    val attr = calculateAttributeModifiers(attributes)
    val skillMods = ProficiencyModifiers(calculateProficiencyBonus(level), 0)

    //new Character()

  }
  */
  //Get all the modifiers
  def calculateAttributeModifiers(attr: Map[String, Int]): List[Attribute] = {
    attr.map {
      case (key,value) =>
        val attributeType = attrList.find(_.name == key).get
        Attribute(
          attributeType = attributeType,
          value = value,
          modifier = calculateAttributeModifier(value)
        )
    }.toList
  }
  //Get one modifier
  def calculateAttributeModifier(inValue: Int): Int = {
    inValue match {
        case value if value < 1 => -5
        case value if value == 1 => -5
        case value if value >= 2 && value <= 3 => -4
        case value if value >= 4 && value <= 5 => -3
        case value if value >= 6 && value <= 7 => -2
        case value if value >= 8 && value <= 9 => -1
        case value if value  >= 10 && value <= 11 => 0
        case value if value  >= 12 && value <= 13 => 1
        case value if value  >= 14 && value <= 15 => 2
        case value if value  >= 16 && value <= 17 => 3
        case value if value  >= 18 && value <= 19 => 4
        case value if value  >= 20 && value <= 21 => 5
        case value if value  >= 22 && value <= 23 => 6
        case value if value  >= 24 && value <= 25 => 7
        case value if value  >= 26 && value <= 27 => 8
        case value if value  >= 28 && value <= 29 => 9
        case _ => 10
      }
  }

  def calculateProficiencyBonus(lvl: Int): Int = {
    floor((7 + lvl) / 4).toInt
  }

  def calculateProficiencyModifiers(attributes: Map[String, Attribute], proficientSkills: List[String]) = ???


  private val baseProficiencyNamesAndGroups = List(
    ("acrobatics", "dexterity"),
    ("animal handling", "wisdom"),
    ("arcana", "intelligence"),
    ("athletics", "strength"),
    ("deception", "charisma"),
    ("history", "intelligence"),
    ("insight", "wisdom"),
    ("intimidation", "charisma"),
    ("investigation", "intelligence"),
    ("medicine", "wisdom"),
    ("nature", "intelligence"),
    ("perception", "wisdom"),
    ("performance", "charisma"),
    ("persuasion", "charisma"),
    ("religion", "intelligence"),
    ("sleight of hand", "dexterity"),
    ("stealth", "dexterity"),
    ("survival", "wisdom")
  )

  private val attrList = List(Strength(),Dexterity(),Constitution(),Intelligence(),Wisdom(),Charisma())

}
