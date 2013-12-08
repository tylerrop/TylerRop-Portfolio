import java.util.Scanner;
import java.io.*;

/**
 * Tests the battle class to ensure that the battle class is working properly
 * run throught the debugger to see if everything is working properly
 * 
 * @author (Tyler Rop) 
 * @version (version 1)
 */
public class battleTesterClass
{
    /**
     * Constructor for objects of class battleTest
     */
    public battleTesterClass()
    {
        //makes a new sword
        sword Needle = new sword(0,"Needle",10,10);
        
        //makes a new axe
        axe Chopper = new axe(0,"Chopper", 15,5);
        
        //makes a new hero
        hero ThatGuy = new hero("ThatGuy",100,23,12,Needle);
        
        //makes a new berserker troll
        berserker Alfred = new berserker("Alfred",100,34,34,Chopper);
        
        //makes a new battle
        battle battle = new battle();
        
        //the hero and troll fight (for testing purposes, no trolls were harming in the making of this test)
        battle.fight(ThatGuy, Alfred,"1","1");
    }
}
