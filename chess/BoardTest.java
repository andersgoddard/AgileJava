package chess;

import junit.framework.TestCase;
import java.util.*;
import chess.pieces.*;

public class BoardTest extends TestCase {
	
	public void testCreate(){
		Board board = new Board();
		board.initialize();
		board.printBoard();
		assertEquals(16, board.getNumberOfPieces());
		String secondRank = board.getSecondRank();
		assertEquals("pppppppp", secondRank);
		String seventhRank = board.getSeventhRank();
		assertEquals("PPPPPPPP", seventhRank);		
	}
	
}