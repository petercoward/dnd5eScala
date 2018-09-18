package peter.coward.character

case class CombatModifiers(armourClass: Int, initiative: Int, speed: Int, currentHP: Int, tempHP: Option[Int] = None)

case class Attribute(attributeType: AttributeType, value: Int, modifier: Int)

case class Money(cp: Int, sp: Int, gp: Int, ep: Int, pp: Int)

case class Proficiency(name: String, ability: String, modifier: Int, proficient: Boolean)

case class ProficiencyModifiers(profBonus: Int, inspiration: Int)

trait AttributeType {
  def name: String
}
case class Strength(name: String = "strength") extends AttributeType
case class Dexterity(name: String = "strength") extends AttributeType
case class Constitution(name: String = "strength") extends AttributeType
case class Intelligence(name: String = "strength") extends AttributeType
case class Wisdom(name: String = "strength") extends AttributeType
case class Charisma(name: String = "strength") extends AttributeType

trait Skill
case class AnimalHandling(name: String = "animal handling", group: AttributeType)