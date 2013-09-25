
/**
 * creates a berserker troll object
 * 
 * @author (Tyler Rop) 
 * @version (version 3)
 */
public class berserker extends troll
{
    /**
     * Constructor for objects of class berserker
     */
    public berserker(String name, int health, int defenseLevel, int coins, weapon currWeapon)
    {
        super(name, health, defenseLevel, coins, currWeapon);
    }

    /**
     * Method - getType
     * returns the trolls type
     */
    public String getType()
    {
        String trollType = "Berserker";

        return trollType;
    }

    /**
     * Method - battleChoice
     * the berserker always attacks
     */
    public String battleChoice()
    {
        return "1";
    }

}
