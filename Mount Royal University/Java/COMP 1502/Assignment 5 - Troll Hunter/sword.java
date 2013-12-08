/**
 * creates a sword object that characters can use in battles
 * 
 * @author (Tyler Rop) 
 * @version (version 2)
 */
public class sword extends weapon
{
    //the power that the sword object has
    protected int power;

    //the length of the sword object
    protected int length;

    //the amount of damage that a sword can inflict
    protected int attack;
    /**
     * Constructor for objects of class sword
     */
    public sword(int useCount, String weaponName, int power, int length)
    {
        super(useCount, weaponName);

        this.power = power;

        this.length = length;
    }

    
    /**
     * Method - getWeaponPower
     * gives back the power of the weapon
     */
    public int getWeaponPower()
    {
        return power;
    }
    
    
    /**
     * Method - attackDamage
     * calcualtes the amount of damage that a sword can inflict
     * the damage amount depends on the swords power, length, and usecount
     * 
     */
    public int attackDamage()
    {
        attack = Math.max(0, (power * length) - useCount);
       
        //makes it so that if a weapon is broken you can only do 1 point of damage (like you were using your fist)   
        if(useCount >= attack)
        {
            attack = 1;
        }
        return attack;
    }
}
