
/**
 * sets up objects that the game will make good guys and bad guys from
 * 
 * @author (Tyler Rop) 
 * @version (version 1)
 */
abstract public class character
{
    //name of the character
    protected String name;
    
    //amount of energy that the character has
    protected int health;
    
    //defense level of character
    protected int defenseLevel;
    
    //amount of coins the character has
    protected int coins;
    
    //determines in the character object is alive or dead
    protected boolean living = true;
   
    //the weapon of the character
    protected weapon currWeapon;
    /**
     * Constructor for objects of class characters
     */
    public character(String name, int health, int defenseLevel, int coins, weapon currWeapon)
    {
       this.name = name;
       
       this.health = health;
       
       this.defenseLevel = defenseLevel;
       
       this.coins = coins;
       
       this.currWeapon = currWeapon;
    }

    //character name setter and getter
    /**
     * Method - getName
     * gets the name of the character
     */
    public String getName()
    {
        return name;
    }
    /**
     * Method - sets the name of the character
     */
    public void setName()
    {
        this.name = name;
    }
    
    //character health setter and getter
    public int getHealth()
    {
        return health;
    }
    public int setHealth(int newHealth)
    {
        health = newHealth;
        
        return health;
    }
    
    //character defense level setter and getter
    public int getDefenseLevel()
    {
        return defenseLevel;
    }
    /**
     * Method - setDefenseLevel
     * sets the new defense level for the character
     */
    public int setDefenseLevel(int newDefense)
    {
        defenseLevel = newDefense;
        
        return defenseLevel;
    }
    
    //character coins setter and getter
    /**
     * Method - getCoins
     * gets the number of coins that the character has
     */
    public int getCoins()
    {
        return coins;
    }
    
    /**
     * Method - setCoins
     * sets the number of coins that the charcter has
     */
    public int setCoins(int newCoins)
    {
        coins = newCoins;
        
        return coins;
    }
    
    /**
     * Method - getCurrWeapon
     * gets the current weapon of the character
     */
    public weapon getCurrWeapon()
    {
        return currWeapon;
    }
    
    /**
     * Method - setCurrWeapon
     * sets the weapon for the character
     */
    public weapon setCurrWeapon(weapon newWeapon)
    {
        currWeapon = newWeapon;
        
        return currWeapon;
    }
    
    /**
     * Method - checkLife
     * 
     * checks to see if the character is living still
     **/
    public boolean checkLife()
    {
        return living;
    }
    
    /**
     * Method - setLiving
     * 
     * sets a character as living
     */
    public boolean setLiving(boolean newLiving)
    {
        living = newLiving;
        
        return living;
    }
    
    /**
     * Method - battleChoice
     * the choice that athe character will chose when fighting (attack or defend)
     */
    public abstract String battleChoice();
    
    /**
     * Method - getType
     * the type of character (hero, berserker troll, randomger troll, big boss troll)
     */
    public abstract String getType();
}
