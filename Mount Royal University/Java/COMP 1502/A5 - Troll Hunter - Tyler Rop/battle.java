import java.util.Random;
import java.awt.Color;
import java.io.*;
import display.*;

/**
 * calculates the actions and health that a troll and the hero will have when fighting
 * 
 * @author (Tyler Rop) 
 * @version (version 1)
 */
public class battle
{
    //bring in the graphical user interface
    GuiInterface displayInterface = GuiInterface.getInstance();

    //the user
    private character user;

    //the troll
    private character troll;

    //user health
    private int userHealth;

    //troll health
    private int trollHeath;

    //user defense amount
    private int userDefense;

    //troll defense amount
    private int trollDefense;

    //user weapon use count
    private int userUseCount;

    //troll weapon use count
    private int trollUseCount;

    //number of coins the user has
    private int userCoins;

    //number of coins the troll hass
    private int trollCoins;

    //what the user enters when they are fighintg
    private String userBattleChoice;

    //what the troll enters when it is battling
    private String trollBattleChoice;

    //a genertaor for getting random numbers
    private Random generator = new Random();

    /**
     * Constructor for objects of class battle
     */
    public battle()
    {
    }
    
    /**
     * Method - fight
     * has the user and troll objects battle to the death
     */
    
    public void fight(character user, character troll, String userBattleChoice, String trollBattleChoice)
    {
        //the user 
        this.user = user;

        //the troll
        this.troll = troll;

        //the choice that the user makes when battling
        this.userBattleChoice = userBattleChoice;

        //the choice that the troll makes when battling
        this.trollBattleChoice = trollBattleChoice;

        //gets the damage that the user can inflict on the troll with the weapon they are using
        int userDamage = user.getCurrWeapon().attackDamage();

        
        //gets the damage that the troll can inflict on the with with the weapon they are using
        int trollDamage = troll.getCurrWeapon().attackDamage();

        //gets the users health amount
        int userHealth = user.getHealth();

        //gets the trolls health amount
        int trollHealth = troll.getHealth();

        //gets the users defense level
        int userDefenseLevel = user.getDefenseLevel();
        
        //gets the trolls defense level
        int trollDefenseLevel = troll.getDefenseLevel();
        
        
        //makes random numbers
        Random generator = new Random();

        //genertates the amount that user and troll can defend between 0 and their respective defense levels
        int userDefense = generator.nextInt(userDefenseLevel);
        int trollDefense = generator.nextInt(trollDefenseLevel);

        //gets the number of coins the user has
        int userCoins = user.getCoins();
        
        //gets the number of coins that the troll has
        int trollCoins = troll.getCoins();
        
        
        
        //situations that can happen when the user and the troll battle are calaculated below
        
        //both troll and user attack each other
        if(userBattleChoice.equals("1") && trollBattleChoice.equals("1"))
        {
            //the trolls health is calculated
            trollHealth = trollHealth - (userDamage);

            //the trolls health is set
            troll.setHealth(trollHealth);

            //the users health is calculated
            userHealth = userHealth - (trollDamage);

            //the users health is calculated
            user.setHealth(userHealth);

            //the users weapon use count ioncreases by 1
            userUseCount++;

            //the trolls weapon use count increases by 1
            trollUseCount++;

            //the user weapon use count is set
            user.getCurrWeapon().setUseCount(userUseCount);

            //the troll weapon use count is set
            troll.getCurrWeapon().setUseCount(trollUseCount);

            //if the trolls attack lowered the users health to zero or less then the user then the user is set as dead
            if(userHealth <= 0)
            {
                user.setLiving(false);
            }

            //if the userss attack lowered the trolls health to zero or less then the user then the user is set as dead
            if(trollHealth <= 0)
            {
                troll.setLiving(false);
            }

            //if the user is still alive after the attack from the troll a message is displayed for them
            if(user.checkLife() == true)
            {
                displayInterface.setUserDisplayMessage("You valiantly slash attack the troll, and the troll meets your attack with a blow of it's own, but you have not defeated the monstrous beast yet");
            }
        }

        //if both troll and user defend
        else if(userBattleChoice.equals("0") && trollBattleChoice.equals("0"))
        {
            //troll health stays as it was
            trollHealth = trollHealth;
            troll.setHealth(trollHealth);

            //user health stays as it was
            userHealth = userHealth;
            user.setHealth(userHealth);

            //a message is displayed for the user 
            displayInterface.setUserDisplayMessage("You plot the demise of the cave troll, and the cave troll plots your demise...");
        }

        //if the user attacks and troll defends
        else if(userBattleChoice.equals("1") && trollBattleChoice.equals("0"))
        {
            //the trolls new lower health is calculated
            trollHealth = trollHealth - (userDamage - trollDefense);
            
            //the trolls new lower health is set
            troll.setHealth(trollHealth);

            //the users weapon use count is increased by 1
            userUseCount++;
            user.getCurrWeapon().setUseCount(userUseCount);

            //if the userss attack lowered the trolls health to zero or less then the user then the user is set as dead
            if(trollHealth <= 0)
            {
                troll.setLiving(false);
            }

            //the user is displayed a message telling them about how awesome they are and how they tried to kill the trololol
            if(user.checkLife() == true)
            {
                displayInterface.setUserDisplayMessage("You valiantly slash attack the troll, but the monstrous beast trys to block your attack");
            }
        }

        //if the user blocks and the troll attacks
        else if(userBattleChoice.equals("0") && trollBattleChoice.equals("1"))
        {
            //the users new health is calculated and then set
            if(trollDamage - userDefense < 0)
            {
                userHealth = userHealth;
            }
            else if (trollDamage - userDefense >= 0)
            {
                userHealth = userHealth - (trollDamage - userDefense);
            }
            user.setHealth(userHealth);

            //the trolls weapon use count is increased and set
            trollUseCount++;
            troll.getCurrWeapon().setUseCount(trollUseCount);

            //if the userss attack lowered the trolls health to zero or less then the user then the user is set as dead
            if(userHealth <= 0)
            {
                user.setLiving(false);
            }

            //if the user is still alive they are displayed a message
            if(user.checkLife() == true)
            {
                displayInterface.setUserDisplayMessage("You bring up your defenses but the ugly troll trys to slay you with his attack");
            }
        }
    }
}
