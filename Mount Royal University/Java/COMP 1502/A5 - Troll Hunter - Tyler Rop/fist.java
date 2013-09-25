
/**
 * the default wqeapon for the hero, they always have this weapon at their disposal
 * 
 * @author (Tyler Rop) 
 * @version (version 2)
 */
public class fist extends weapon
{

    /**
     * Constructor for objects of class fist
     */
    public fist()
    {
        //fist durability is always zero and always returns 1
        super(0, "Fist");
    }

    
    /**
     * Method - getWeaponPower
     * gives back the power of the weapon
     */
    public int getWeaponPower()
    {
        return 1;
    }
    
    //this method will always apply 1 point of attack damage every time that it is used 
    /**
     * Method - attackDamage
     * calcuating the amount of damage that a weapon does
     */
    public int attackDamage()
    {
        return 1;
    }
}
