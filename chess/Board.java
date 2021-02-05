package chess;

import java.util.*;
import chess.pieces.*;
import util.StringUtil;

public class Board {

	final static String white = "white";
	final static String black = "black";	
	final static String pawn = "pawn";	
	final static String knight = "knight";	
	final static String bishop = "bishop";	
	final static String rook = "rook";	
	final static String queen = "queen";	
	final static String king = "king";		
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	private ArrayList<Piece> firstRank = new ArrayList<Piece>();
	private ArrayList<Piece> secondRank = new ArrayList<Piece>();
	private ArrayList<Character> thirdRank = new ArrayList<Character>();
	private ArrayList<Character> fourthRank = new ArrayList<Character>();
	private ArrayList<Character> fifthRank = new ArrayList<Character>();
	private ArrayList<Character> sixthRank = new ArrayList<Character>();
	private ArrayList<Piece> seventhRank = new ArrayList<Piece>();
	private ArrayList<Piece> eighthRank = new ArrayList<Piece>();
	
	void initialize(){
		firstRank.add(Piece.createPiece(white, rook));
		firstRank.add(Piece.createPiece(white, knight));
		firstRank.add(Piece.createPiece(white, bishop));
		firstRank.add(Piece.createPiece(white, queen));
		firstRank.add(Piece.createPiece(white, king));
		firstRank.add(Piece.createPiece(white, bishop));
		firstRank.add(Piece.createPiece(white, knight));
		firstRank.add(Piece.createPiece(white, rook));

		for (int i = 0; i < 8; i++){
			secondRank.add(Piece.createPiece(white, pawn));
			seventhRank.add(Piece.createPiece(black, pawn));
		}
		
		eighthRank.add(Piece.createPiece(black, rook));
		eighthRank.add(Piece.createPiece(black, knight));
		eighthRank.add(Piece.createPiece(black, bishop));
		eighthRank.add(Piece.createPiece(black, queen));
		eighthRank.add(Piece.createPiece(black, king));
		eighthRank.add(Piece.createPiece(black, bishop));
		eighthRank.add(Piece.createPiece(black, knight));
		eighthRank.add(Piece.createPiece(black, rook));		
	}
	
	int pieceCount(){
		return Piece.getCount();
	}
	
	ArrayList<Piece> getPieces(){
		return pieces;
	}
	
	String getRank(ArrayList<Piece> rank){
		StringBuilder buffer = new StringBuilder();
		
		for (Piece piece : rank) {
			buffer.append(piece.getCharacterRepresentation());
		}
		
		return buffer.toString();
	}
	
	String getBlankRank(){
		StringBuilder buffer = new StringBuilder();
		
		for (int i = 0; i < 8; i++) {
			buffer.append('.');
		}
		
		return buffer.toString();		
	}
	
	String print(){
		
		String blankRank = StringUtil.appendNewLine(getBlankRank());
		return StringUtil.appendNewLine(getRank(eighthRank)) + 
			   StringUtil.appendNewLine(getRank(seventhRank)) + 
			   blankRank + blankRank + blankRank + blankRank + 
			   StringUtil.appendNewLine(getRank(secondRank)) + 
			   StringUtil.appendNewLine(getRank(firstRank));
	}
}