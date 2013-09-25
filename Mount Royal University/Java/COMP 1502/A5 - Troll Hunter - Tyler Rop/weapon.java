
/**
 * parent class for creating specific weapon objects that are used by troll and the hero
 * 
 * @author (Tyler Rop) 
 * @version (version 2)
 */
abstract public class weapon
{
    // variable for the number of time that the weapon is used
    protected int useCount;
    
    //name of the weapon
    protected String weaponName;
    
    //how much it costs to repoair a weapon
    protected static final int REPAIR_COST = 5;

    /**
     * Constructor for objects of class weapons
     */
    public weapon(int useCount, String weaponName)
    {
        // initialise instance variables
        this.useCount = useCount;
        
        this.weaponName = weaponName;
        
    }
    
    //weapon use count setter and getter
    public int getUseCount()
    {
        return useCount;
    }
    public int setUseCount(int newCount)
    {
        useCount = newCount;
        
        return useCount;
    }
    
    //weapon name setter and getter
    public String getWeaponName()
    {
        return weaponName;
    }
    public void setWeaponName()
    {
        this.weaponName = weaponName;
    }
   
    /**
     * Method - useCounter
     * adds to the use count of the weapon
     */
    public void useCounter()
    {
        useCount = useCount + 1;
    }
    
    /**
     * Method - repair
     * repairs a weapon
     */
    public void repair()
    {
        useCount = Math.max(0, useCount + REPAIR_COST);
    }
    
    /**
     * Method - getWeaponPower
     * gives back the power of the weapon
     */
    public abstract int getWeaponPower();
    
    /**
     * Method - attackDamage
     * calcuating the amount of dsamage that a weapon does
     */ 
    public abstract int attackDamage();
}
