
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class killaswordTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class killAllSwordTest
{
    private  killAllSword killAllSword;   
    /**
     * Default constructor for test class killaswordTest
     */
    public killAllSwordTest()
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
        killAllSword = new killAllSword();
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
    public void first_test_for_hitting_with_awsome_sword_should_do_99999_points_of_damage()
    {
        int damageIfHit = killAllSword.attackDamage();
        
        assertEquals(99999, damageIfHit);
    }
    
    @Test
    public void when_killasword_is_used_3_times_it_should_still_do_99999_points_of_damage()
    {
        TestHelper.hitting(killAllSword, 3);
        
        assertEquals(99999,killAllSword.attackDamage());
    }
}