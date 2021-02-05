package chess.pieces;

public class Piece {
	
	final static String white = "white";
	final static String black = "black";
	static int pieceCount = 0;
	
	private String color;
	private String name;
	private char characterRepresentation;
	
	private Piece(String color, String name){
		this.color = color;
		this.name = name;
		
		if (name == "pawn")
			this.characterRepresentation = 'p';
		else if (name == "knight")
			this.characterRepresentation = 'n';
		else if (name == "rook")
			this.characterRepresentation = 'r';
		else if (name == "bishop")
			this.characterRepresentation = 'b';
		else if (name == "queen")
			this.characterRepresentation = 'q';
		else if (name == "king")
			this.characterRepresentation = 'k';		

		if (color == "black")
			setBlackChar();		
		
		pieceCount++;
	}
	
	public static int getCount(){
		return pieceCount;
	}
	
	String getColor(){
		return color;
	}
	
	String getName(){
		return name;
	}
	
	public char getCharacterRepresentation(){
		return characterRepresentation;
	}
	
	public static Piece createPiece(String color, String name){
		return new Piece(color, name);
	}
	
	void setBlackChar(){
		this.characterRepresentation = Character.toUpperCase(this.characterRepresentation);
	}
	
	boolean isBlack(){
		return this.getColor() == "black";
	}
	
	boolean isWhite(){
		return this.getColor() == "white";
	}
}