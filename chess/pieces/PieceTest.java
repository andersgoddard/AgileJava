package chess.pieces;

import junit.framework.TestCase;

public class PieceTest extends TestCase {
	
	final static String white = "white";
	final static String black = "black";	
	final static String pawn = "pawn";	
	final static String knight = "knight";	
	final static String bishop = "bishop";	
	final static String rook = "rook";	
	final static String queen = "queen";	
	final static String king = "king";	
	
	public void testCreatePawn(){

		Piece whitePawn = Piece.createPiece(white, pawn);		
		assertEquals(white, whitePawn.getColor());
		assertEquals('p', whitePawn.getCharacterRepresentation());

		Piece blackPawn = Piece.createPiece(black, pawn);
		assertEquals(black, blackPawn.getColor());
		assertEquals('P', blackPawn.getCharacterRepresentation());
	}
	
	public void testCreateKnight(){
		Piece whiteKnight = Piece.createPiece(white, knight);
		assertEquals(white, whiteKnight.getColor());
		assertEquals('n', whiteKnight.getCharacterRepresentation());
		
		Piece blackKnight = Piece.createPiece(black, knight);
		assertEquals(black, blackKnight.getColor());
		assertEquals('N', blackKnight.getCharacterRepresentation());
	}

	public void testCreateRook(){
		Piece whiteRook = Piece.createPiece(white, rook);
		assertEquals(white, whiteRook.getColor());
		assertEquals('r', whiteRook.getCharacterRepresentation());
		
		Piece blackRook = Piece.createPiece(black, rook);
		assertEquals(black, blackRook.getColor());
		assertEquals('R', blackRook.getCharacterRepresentation());
	}

	public void testCreateBishop(){
		Piece whiteBishop = Piece.createPiece(white, bishop);
		assertEquals(white, whiteBishop.getColor());
		assertEquals('b', whiteBishop.getCharacterRepresentation());
		
		Piece blackBishop = Piece.createPiece(black, bishop);
		assertEquals(black, blackBishop.getColor());
		assertEquals('B', blackBishop.getCharacterRepresentation());
	}

	public void testCreateKing(){
		Piece whiteKing = Piece.createPiece(white, king);
		assertEquals(white, whiteKing.getColor());
		assertEquals('k', whiteKing.getCharacterRepresentation());
		
		Piece blackKing = Piece.createPiece(black, king);
		assertEquals(black, blackKing.getColor());
		assertEquals('K', blackKing.getCharacterRepresentation());
	}

	public void testCreateQueen(){
		Piece whiteQueen = Piece.createPiece(white, queen);
		assertEquals(white, whiteQueen.getColor());
		assertEquals('q', whiteQueen.getCharacterRepresentation());
		
		Piece blackQueen = Piece.createPiece(black, queen);
		assertEquals(black, blackQueen.getColor());
		assertEquals('Q', blackQueen.getCharacterRepresentation());
	}	
	
	public void testIsWhite(){
		Piece whitePawn = Piece.createPiece(white, pawn);
		assertTrue(whitePawn.isWhite());
		assertFalse(whitePawn.isBlack());
	}

	public void testIsBlack(){
		Piece blackPawn = Piece.createPiece(black, pawn);
		assertTrue(blackPawn.isBlack());
		assertFalse(blackPawn.isWhite());
	}
	
}