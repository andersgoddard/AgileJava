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
	

	public void testCreate(){
		verifyCreation(Piece.createWhitePawn(), Piece.createBlackPawn(), Piece.Type.PAWN, Piece.PAWN_REPRESENTATION);
		verifyCreation(Piece.createWhiteRook(), Piece.createBlackRook(), Piece.Type.ROOK, Piece.ROOK_REPRESENTATION);
		verifyCreation(Piece.createWhiteKnight(), Piece.createBlackKnight(), Piece.Type.KNIGHT, Piece.KNIGHT_REPRESENTATION);
		verifyCreation(Piece.createWhiteBishop(), Piece.createBlackBishop(), Piece.Type.BISHOP, Piece.BISHOP_REPRESENTATION);
		verifyCreation(Piece.createWhitePawn(), Piece.createBlackKing(), Piece.Type.KING, Piece.KING_REPRESENTATION);
		verifyCreation(Piece.createWhitePawn(), Piece.createBlackQueen(), Piece.Type.QUEEN, Piece.QUEEN_REPRESENTATION);
		Piece blank = Piece.noPiece();
		assertEquals('.', blank.getRepresentation());
		assertEquals(Piece.Type.NO_PIECE, blank.getType());
	}
	
	private void verifyCreation(Piece whitePiece, Piece blackPiece, Piece.Type type, char representation){
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());
		assertEquals(representation, whitePiece.getRepresentation());
		
		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
		assertEquals(representation, blackPiece.getRepresentation());
		
	}	
}