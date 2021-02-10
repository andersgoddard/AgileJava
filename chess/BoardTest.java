package chess;

import junit.framework.TestCase;
import util.StringUtil;
import chess.pieces.*;

public class BoardTest extends TestCase {
	
	private Board board;
	
	protected void setUp(){
		board = new Board();
		Piece.resetCount();
		assertEquals(0, board.pieceCount());
		board.initialize();		
	}
	
	public void testCreate(){
		assertEquals(32, board.pieceCount());
		String blankRank = StringUtil.appendNewLine("........");
		assertEquals(StringUtil.appendNewLine("RNBQKBNR") + 
					 StringUtil.appendNewLine("PPPPPPPP") + 
					 blankRank + blankRank + blankRank + blankRank + 
					 StringUtil.appendNewLine("pppppppp") + 
					 StringUtil.appendNewLine("rnbqkbnr"), 
					 board.print());
		System.out.println("\n" + board.print());
	}	
	
	public void testNumberOfPieces(){
		assertEquals(8, board.getPieceCount(Piece.Color.WHITE, Piece.Type.PAWN));
	}
	
	public void testGetPieceAt(){
		Piece blackRook = board.getPieceAt("a8");
		assertTrue(blackRook.isBlack());
		assertEquals(Piece.Type.ROOK, blackRook.getType());
		
		Piece whiteKing = board.getPieceAt("e1");
		assertTrue(whiteKing.isWhite());
		assertEquals(Piece.Type.KING, whiteKing.getType());
	}
	
	public void testSetPieceAt(){
		board.setPieceAt("c7", Piece.createBlackRook());
		Piece blackRook = board.getPieceAt("c7");
		assertEquals("c7", blackRook.getPosition());
		assertTrue(blackRook.isBlack());
		assertEquals(Piece.Type.ROOK, blackRook.getType());
		
		board.setPieceAt("f2", Piece.createWhiteKing());
		Piece whiteKing = board.getPieceAt("f2");
		assertEquals("f2", whiteKing.getPosition());
		assertTrue(whiteKing.isWhite());
		assertEquals(Piece.Type.KING, whiteKing.getType());	
	}
	
	public void testPieceStrengths(){
		Board newBoard = new Board();
		Piece.resetCount();
		newBoard.createBoard();
		
		newBoard.setPieceAt("a8", Piece.createBlackRook());
		assertEquals(5.0, newBoard.getStrength(Piece.Color.BLACK));
		newBoard.setPieceAt("b8", Piece.createBlackKnight());
		assertEquals(7.5, newBoard.getStrength(Piece.Color.BLACK));
		newBoard.setPieceAt("c8", Piece.createBlackBishop());
		assertEquals(10.5, newBoard.getStrength(Piece.Color.BLACK));
		newBoard.setPieceAt("d8", Piece.createBlackQueen());
		assertEquals(19.5, newBoard.getStrength(Piece.Color.BLACK));
		newBoard.setPieceAt("a7", Piece.createBlackPawn());
		assertEquals(20.5, newBoard.getStrength(Piece.Color.BLACK));
		newBoard.setPieceAt("b6", Piece.createBlackPawn());
		assertEquals(21.5, newBoard.getStrength(Piece.Color.BLACK));
		newBoard.setPieceAt("e4", Piece.createBlackPawn());
		newBoard.setPieceAt("e5", Piece.createBlackPawn());
		assertEquals(22.5, newBoard.getStrength(Piece.Color.BLACK));
		
		assertEquals(9.0, newBoard.getPieces(Piece.Color.BLACK).get(0).getStrength());
	}
	
	public void testSetPieceStrengths(){
		Board newBoard = new Board();
		Piece.resetCount();
		newBoard.createBoard();
		
		Piece blackRook = Piece.createBlackRook();
		assertEquals(0.0, blackRook.getStrength());
		newBoard.setPieceAt("a8", blackRook);
		assertEquals(5.0, blackRook.getStrength());
		
		Piece whitePawn1 = Piece.createWhitePawn();
		newBoard.setPieceAt("g2", whitePawn1);
		assertEquals(1.0, whitePawn1.getStrength());
		
		assertEquals(1.0, newBoard.getStrength(Piece.Color.WHITE));
		assertEquals(5.0, newBoard.getStrength(Piece.Color.BLACK));
		
		Piece whitePawn2 = Piece.createWhitePawn();
		newBoard.setPieceAt("g3", whitePawn2);
		assertEquals(1.0, newBoard.getStrength(Piece.Color.WHITE));	
		assertEquals(0.5, whitePawn2.getStrength());
		assertEquals(0.5, whitePawn1.getStrength());
	}
	
	public void testCreateBlankBoard(){
		Board blankBoard = new Board();
		blankBoard.createBoard();
		
		assertEquals(8, blankBoard.getBoard().size());
		assertEquals(8, blankBoard.getBoard().get(0).size());		
		assertEquals(8, blankBoard.getBoard().get(7).size());		
		
		blankBoard.buildBoard();
		Piece blackRook = blankBoard.getPieceAt("a8");
		assertEquals(Piece.Type.ROOK, blackRook.getType());
		assertTrue(blackRook.isBlack());
		
		Piece whiteQueen = blankBoard.getPieceAt("d1");
		assertEquals(Piece.Type.QUEEN, whiteQueen.getType());
		assertTrue(whiteQueen.isWhite());
	}
}