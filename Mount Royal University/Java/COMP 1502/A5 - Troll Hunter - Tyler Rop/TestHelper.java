
/**
 * this class simply is used to test weapon objects and calculations to make sure theyre working right (uses the JUnit testing classes for this)
 * 
 * @author (Tyler Rop) 
 * @version (version 1)
 */
public class TestHelper
{
    //uses a weapon to attack and check the damage that the weapon does and how many times it is actually used
    public static void hitting(weapon weapon, int howManyTimesYouHit)
    {
        for (int i= 1; i <= howManyTimesYouHit; i++)
        {
            weapon.useCounter();
            weapon.attackDamage();
        }
    }
    
    //this tests if the uses choses to attack or defend
    public static void battleMove(character character, String theMove)
    {
        character.battleChoice();
    }
}
