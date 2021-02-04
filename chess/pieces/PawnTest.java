package chess.pieces;

import junit.framework.TestCase;

public class PawnTest extends TestCase {
	
	final static String white = "white";
	final static String black = "black";	
	
	public void testCreate(){

		Pawn whitePawn = new Pawn(white, 'p');		
		assertEquals(white, whitePawn.getColor());
		assertEquals('p', whitePawn.getCharacterRepresentation());
		Pawn blackPawn = new Pawn(black, 'P');
		assertEquals(black, blackPawn.getColor());
		assertEquals('P', blackPawn.getCharacterRepresentation());
		Pawn pawn = new Pawn();
		
	}
	
}