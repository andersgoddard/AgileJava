package chess.pieces;

public class Pawn {
	
	final static String white = "white";
	final static String black = "black";
	
	private String color;
	private char characterRepresentation;
	
	public Pawn(String color, char characterRepresentation){
		this.color = color;
		this.characterRepresentation = characterRepresentation;
	}
	
	public Pawn(){
		this.color = white;
		this.characterRepresentation = 'p';
	}
	
	String getColor(){
		return color;
	}
	
	public char getCharacterRepresentation(){
		return characterRepresentation;
	}
	
}