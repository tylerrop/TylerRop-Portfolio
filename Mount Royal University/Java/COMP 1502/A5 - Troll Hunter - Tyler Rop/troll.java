
/**
 * derives troll objects from the charcter parent class
 * 
 * @author (Tyler Rop) 
 * @version (version 2)
 */
abstract public class troll extends character
{
    /**
     * Constructor for objects of class troll
     */
    public troll(String name, int health, int defenseLevel, int coins, weapon currWeapon)
    {
        super(name, health, defenseLevel, coins, currWeapon);
    }

    /**
     * Method - battleChoice
     * what the user will do in battle (attack or defend)
     */
    public abstract String battleChoice();
    
    /**
     * Method - getType
     * the type of character(berserker troll, randomger troll, big boss troll)
     */
    public abstract String getType();
}
