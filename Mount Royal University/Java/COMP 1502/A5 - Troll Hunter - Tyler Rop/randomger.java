import java.util.Random;
/**
 * creates the randomger troll, it doesnt know if it likes to attack or defend
 * 
 * @author (Tyler Rop) 
 * @version (version 1)
 */
public class randomger extends troll
{
    //the random number that is used to determine if the troll attacks or defends
    private   int randomNum;

    /**
     * Constructor for objects of class randomger
     */
    public randomger(String name, int health, int defenseLevel, int coins, weapon currWeapon)
    {
        super(name, health, defenseLevel, coins, currWeapon);
    }

    /**
     * Method - getType
     * returns the trolls type
     */
    public String getType()
    {
        String trollType = "Randomger";
        
        return trollType;
    }
    
    /**
     * Method - battleChoice
     * decides if the rondomger troll will attack or defend
     */
    public String battleChoice()
    { 
        //makes random numbers
        Random generator = new Random();

        //genertates either a 0 or a 1
        randomNum = generator.nextInt(2);

        //if the random number is a zero then the troll will defend
        if(randomNum == 0)
        {
            return "0";
        }

        //if the random number is a 1 then the troll will attack
        else
        {
            return "1";
        }
    }

}
