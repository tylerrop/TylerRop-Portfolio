import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class battleTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class battleTest
{
    private battle battle = new battle();

    //indicator to see if the troll is dead or alive
    private boolean trollIsDead = false;

    private boolean heroIsDead = false;

    //a troll object
    private character troll;
    
    //another troll object
    private character beastTroll;

    //a user object
    private hero hero;
    
    //another user object
    private hero someGuy;

    //health of a troll
    private int trollHealth;

    //choice to attack or defend (troll)
    private String trollBattleChoice;

    //initial health for the hero/user
    private int startHeroHealth;

    //initial health for a troll
    private int startTrollHealth;

    //health of a user after a battle sequence
    private int afterFightUserHealth;

    //health of a troll after a sequence
    private int afterFightTrollHealth;
    
    //health of a user after a battle sequence
    private int afterFightDefendUserHealth;
    
    //health of a troll after a battle sequence
    private int afterFightDefendTrollHealth;
    /**
     * Default constructor for test class battleTest
     */
    public battleTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        //new sword object
        weapon sword = new sword(0, "Jaime's Sword", 10, 2);
        
        //new dagger object
        weapon dagger = new dagger(0, "Troll's Crappy Dagger",5);
        
        //new kill all object
        weapon killALL = new killAllSword();
        
        //another kill all object
        weapon killALL2 = new killAllSword();

        //a new user/hero object
        hero = new hero("Jaime Lannister", 100, 78, 99999, sword);
        
        //another user/hero object
        someGuy = new hero("Some Guy", 100, 100, 100, killALL);

        //a new berserker troll object
        troll = new berserker("Troller", 35,  10, 10, dagger);
        
        //another new berserker troll object
        beastTroll = new berserker("Beasty", 99999, 99999, 99999, killALL2);

        startHeroHealth = 100;

        startTrollHealth = 35;

        afterFightUserHealth = 95;

        afterFightTrollHealth = 15;
        
        afterFightDefendUserHealth = 100;
        
        afterFightDefendTrollHealth = 35;
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void Test_to_see_if_both_can_do_damage_to_the_troll_if_they_both_attack()
    {
        battle.fight(hero, troll, "1", "1");

        assertEquals(95, afterFightUserHealth);
        assertEquals(15, afterFightTrollHealth);
    }
    
    @Test
    public void Test_to_see_if_no_damage_is_done_if_both_defend()
    {
        battle.fight(hero, troll, "0", "0");
        
        assertEquals(100, afterFightDefendUserHealth);
        assertEquals(35,  afterFightDefendTrollHealth);
    }
    
    @Test
    public void Test_to_see_if_the_user_can_kill_the_troll_when_the_troll_is_defending()
    {
       battle.fight(someGuy, troll, "1", "0");
       
       assertFalse(troll.checkLife());
    }
    
    @Test
    public void Test_to_see_if_the_troll_can_kill_a_user_when_they_both_attack()
    {
        battle.fight(hero, beastTroll, "1", "1");
        
        assertFalse(hero.checkLife());
    }
}
