package chess.pieces;

import java.util.*;

public class Piece implements Comparable<Piece> {
	
	final static char PAWN_REPRESENTATION = 'p';
	final static char ROOK_REPRESENTATION = 'r';
	final static char KNIGHT_REPRESENTATION = 'n';
	final static char BISHOP_REPRESENTATION = 'b';
	final static char QUEEN_REPRESENTATION = 'q';
	final static char KING_REPRESENTATION = 'k';
	static int pieceCount = 0;
	
	public enum Color {BLACK, WHITE};
	public enum Type {PAWN, ROOK, KNIGHT, BISHOP, KING, QUEEN, NO_PIECE};
	Color color;
	Type type;
	private char representation;
	private String position;
	private double strength;
	
	private Piece(Color color, Type type){
		this.type = type;
		this.color = color;
		
		if (type == Type.PAWN)
			this.representation = PAWN_REPRESENTATION;
		else if (type == Type.KNIGHT)
			this.representation = KNIGHT_REPRESENTATION;
		else if (type == Type.ROOK)
			this.representation = ROOK_REPRESENTATION;
		else if (type == Type.BISHOP)
			this.representation = BISHOP_REPRESENTATION;
		else if (type == Type.QUEEN)
			this.representation = QUEEN_REPRESENTATION;
		else if (type == Type.KING)
			this.representation = KING_REPRESENTATION;		
		else if (type == Type.NO_PIECE)
			this.representation = '.';
		
		if (color == Color.BLACK)
			setBlackChar();
		
		pieceCount++;
	}
	
	public void setPosition(String position){
		this.position = position;
	}
	
	public String getPosition(){
		return position;
	}
	
	private Piece(Type type){
		this.type = type;
		this.representation = '.';
	}
	
	public void setStrength(double strength){
		this.strength = strength;
	}
	
	public double getStrength(){
		return this.strength;
	}
	
	public boolean isBlack(){
		return this.getColor() == Color.BLACK;
	}
	
	public boolean isWhite(){
		return this.getColor() == Color.WHITE;
	}
	
	public Color getColor(){
		return color;
	}
	
	public Type getType(){
		return type;
	}	
	
	public static int getCount(){
		return pieceCount;
	}
	
	public static void resetCount(){
		pieceCount = 0;
	}
	
	public char getRepresentation(){
		return representation;
	}
	
	private static Piece createPawn(Color color){
		return new Piece(color, Type.PAWN);
	}
	
	public static Piece createWhitePawn(){
		return createPawn(Color.WHITE);
	}
	
	public static Piece createBlackPawn(){
		return createPawn(Color.BLACK);
	}
	
	private static Piece createRook(Color color){
		return new Piece(color, Type.ROOK);
	}
	
	public static Piece createWhiteRook(){
		return createRook(Color.WHITE);
	}

	public static Piece createBlackRook(){
		return createRook(Color.BLACK);
	}
	
	private static Piece createKnight(Color color){
		return new Piece(color, Type.KNIGHT);
	}
	
	public static Piece createWhiteKnight(){
		return createKnight(Color.WHITE);
	}

	public static Piece createBlackKnight(){
		return createKnight(Color.BLACK);
	}
	
	private static Piece createBishop(Color color){
		return new Piece(color, Type.BISHOP);
	}
	
	public static Piece createWhiteBishop(){
		return createBishop(Color.WHITE);
	}

	public static Piece createBlackBishop(){
		return createBishop(Color.BLACK);
	}
	
	private static Piece createQueen(Color color){
		return new Piece(color, Type.QUEEN);
	}

	public static Piece createWhiteQueen(){
		return createQueen(Color.WHITE);
	}

	public static Piece createBlackQueen(){
		return createQueen(Color.BLACK);
	}	
	
	private static Piece createKing(Color color){
		return new Piece(color, Type.KING);
	}

	public static Piece createWhiteKing(){
		return createKing(Color.WHITE);
	}

	public static Piece createBlackKing(){
		return createKing(Color.BLACK);
	}
	
	public static Piece noPiece(){
		return new Piece(Type.NO_PIECE);
	}
	
	private void setBlackChar(){
		this.representation = Character.toUpperCase(this.representation);
	}
	
	public int compareTo(Piece that){
		
		Double thatDouble = new Double(that.getStrength());
		Double thisDouble = new Double(this.getStrength());
		
		return thatDouble.compareTo(thisDouble);
	}

}