package tests;

import junit.framework.Test;
import junit.framework.TestSuite;



public class AllGameUtilTests 
{

	 public static Test suite()
	 {
		 TestSuite suite = new TestSuite("GameUtil Tests");
		 suite.addTestSuite(TestCard.class);
		 suite.addTestSuite(TestDeck.class);
		 return suite;
	 }
	
}
