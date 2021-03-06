package tests;

import junit.framework.TestCase;
import tests.UnitTest;

public class UnitTestTest extends TestCase {
	
	
	public static void test(){
		UnitTest ut = new UnitTest();
		System.out.println(ut.testMain());
		assertEquals(ut.testBoardFull(), true);
		assertEquals(ut.testCheckTile(), true);
		assertEquals(ut.testDiagonalCheck(), true);
		assertEquals(ut.testHorizontalCheck(), true);
		assertEquals(ut.testMakeBoard(), true);
		assertEquals(ut.testMakeMove(), true);
		assertEquals(ut.testPlayerMove(), true);
		assertEquals(ut.testUpdatedMakeMove(), true);
		assertEquals(ut.testVerticalCheck(), true);
	}
}
