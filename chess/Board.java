package chess;

import java.util.*;
import chess.pieces.*;
import util.StringUtil;

public class Board {
	
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
		firstRank.add(Piece.createWhiteRook());
		firstRank.add(Piece.createWhiteKnight());
		firstRank.add(Piece.createWhiteBishop());
		firstRank.add(Piece.createWhiteQueen());
		firstRank.add(Piece.createWhiteKing());
		firstRank.add(Piece.createWhiteBishop());
		firstRank.add(Piece.createWhiteKnight());
		firstRank.add(Piece.createWhiteRook());

		for (int i = 0; i < 8; i++){
			secondRank.add(Piece.createWhitePawn());
			seventhRank.add(Piece.createBlackPawn());
		}
		
		eighthRank.add(Piece.createBlackRook());
		eighthRank.add(Piece.createBlackKnight());
		eighthRank.add(Piece.createBlackBishop());
		eighthRank.add(Piece.createBlackQueen());
		eighthRank.add(Piece.createBlackKing());
		eighthRank.add(Piece.createBlackBishop());
		eighthRank.add(Piece.createBlackKnight());
		eighthRank.add(Piece.createBlackRook());		
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
			buffer.append(piece.getRepresentation());
		}
		
		return buffer.toString();
	}
	
	String getBlankRank(){
		StringBuilder buffer = new StringBuilder();
		
		for (int i = 0; i < 8; i++) {
			buffer.append(Piece.noPiece().getRepresentation());
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