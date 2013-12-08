import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class fistTest.
 *
 * @author  (Tyler Rop)
 * @version (version 1)
 */
public class fistTest
{
    private fist fister;
    /**
     * Default constructor for test class fistTest
     */
    public fistTest()
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
        fister = new fist();
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
    public void first_test_for_first_hit_should_do_1_point_of_damage()
    {
        int damageIfHit = fister.attackDamage();
        
        assertEquals(1, damageIfHit);
    }
    
    @Test
    public void when_a_fist_hits_alot_it_always_does_1_point_of_damage()
    {
        TestHelper.hitting(fister, 10);
        
        assertEquals(1, fister.attackDamage());
    }
    
    @Test
    public void when_fist_is_repaired_it_still_does_1_point_of_damage()
    {
        TestHelper.hitting(fister, 10);
        
        fister.repair();
        
        assertEquals(1, fister.attackDamage());
    }
}
