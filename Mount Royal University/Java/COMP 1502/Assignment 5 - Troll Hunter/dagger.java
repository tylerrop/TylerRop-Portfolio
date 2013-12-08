/**
 * creates the dagger weapon that the user or troll can use in a fight
 * 
 * @author (Tyler Rop) 
 * @version (version 2)
 */
public class dagger extends weapon
{
    //amount of power that the dagger has
    protected int power;

    //the amount of damage that a dagger can inflict
    protected int attack;
    
    /**
     * Constructor for objects of class dagger
     */
    public dagger(int useCount, String weaponName, int power)
    {
        super(useCount, weaponName);

        this.power = power;

    }

    
    
    /**
     * Method - getWeaponPower
     * gives back the power of the weapon
     */
    public int getWeaponPower()
    {
        return power;
    }
    
    
    //this method calcualtes the amount of damage that the user or troll can inflict on their opponant with their dagger weapon
    //the amount of damage that the character could inflict depends on the daggers power and use count
    /**
     * Method - attackDamage
     * the damage for an attack with a dagger is calculated
     * 
     */
    public int attackDamage()
    {
        attack = Math.max(0, power - useCount);
        
        //makes it so that if a weapon is broken you can only do 1 point of damage (like you were using your fist)   
        if(useCount >= attack)
        {
            attack = 1;
        }
        return attack;
    }
}

