
/**
 * creates an axe weapon object that characters can use to fight
 * 
 * @author (Tyler Rop) 
 * @version (version 2)
 */
public class axe extends weapon
{
    //power of the axe
    protected int power;

    //weight of the axe
    protected int weight;

    protected int attack;
    /**
     * Constructor for objects of class axe
     */
    public axe(int useCount, String weaponName, int power, int weight)
    {
        super(useCount, weaponName);

        this.power = power;

        this.weight = weight;
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
     * calculates and returns the amount of damage that an axe can inflict on the opponant 
     * 
     * the damage that an axe can do depends on the axes power, weight, and the number of times it has been used
     * 
     */
    public int attackDamage()
    {
        attack = Math.max(0, power - (weight * useCount));
        //makes it so that if a weapon is broken you can only do 1 point of damage (like you were using your fist)   
        if(useCount >= attack)
        {
            attack = 1;
        }
        return attack;
    }
}
