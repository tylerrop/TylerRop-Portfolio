
/**
 * creates the big boss troll
 * 
 * @author (Tyler Rop) 
 * @version (version 3)
 */
public class bigBoss extends troll
{
    //the trolls attack move (attack or defend)
    private String currentAttack;
    
    //counter for what the boss troll will do when he attacks
    private int bossCounter = 0;
    
    /**
     * Constructor for objects of class bigBoss
     */
    public bigBoss(String name, int health, int defenseLevel, int coins, weapon currWeapon)
    {
        super(name, health, defenseLevel, coins, currWeapon);   
    }

    /**
     * Method - getType
     * returns the trolls type
     */
    public String getType()
    {
        String trollType = "Big Boss";
        
        return trollType;
    }
    
    /**
     * Method - battleChoice
     * the big boss troll always does a set attack and defend routine
     */
    public String battleChoice()
    {
        //the big boss troll has 3 set attack moves that are looped continuouslly by the battle until the hero or the boss is dead
        if (bossCounter == 0)
        {
            currentAttack = "1";
            
            bossCounter++;
        }
        else if (bossCounter == 1)
        {
            currentAttack = "0";
            
            bossCounter++;
        }
        else if (bossCounter == 2)
        {
            currentAttack = "0";
            
            bossCounter = 0;
        }
        //the bosses atack move is returned as input for the battle class
        return currentAttack;
    }
}
