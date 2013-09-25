package tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests 
{
	 public static Test suite()
	 {
		 TestSuite suite = new TestSuite("All Tests");
		 suite.addTest(AllGameUtilTests.suite());
		 suite.addTestSuite(TestMove.class);
		 return suite;
	 }
}
