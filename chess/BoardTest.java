package chess;

import junit.framework.TestCase;
import util.StringUtil;
import chess.pieces.*;

public class BoardTest extends TestCase {
	
	private Board board;
	
	protected void setUp(){
		board = new Board();
	}
	
	public void testCreate(){
		Piece.resetCount();
		board.initialize();
		assertEquals(32, board.pieceCount());
		String blankRank = StringUtil.appendNewLine("........");
		assertEquals(StringUtil.appendNewLine("RNBQKBNR") + 
					 StringUtil.appendNewLine("PPPPPPPP") + 
					 blankRank + blankRank + blankRank + blankRank + 
					 StringUtil.appendNewLine("pppppppp") + 
					 StringUtil.appendNewLine("rnbqkbnr"), 
					 board.print());
	}	
}