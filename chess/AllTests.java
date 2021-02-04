package chess;

public class AllTests {
	public static junit.framework.TestSuite suite(){	
		junit.framework.TestSuite suite = new junit.framework.TestSuite();
		suite.addTestSuite(chess.pieces.PawnTest.class);
		suite.addTestSuite(chess.BoardTest.class);
		return suite;		
	}
}