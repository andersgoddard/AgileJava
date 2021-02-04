package chess;

import java.util.*;
import chess.pieces.*;

public class Board {

	final static String white = "white";
	final static String black = "black";		
	private ArrayList<Pawn> pieces = new ArrayList<Pawn>();
	private ArrayList<Character> firstRank = new ArrayList<Character>();
	private ArrayList<Pawn> secondRank = new ArrayList<Pawn>();
	private ArrayList<Character> thirdRank = new ArrayList<Character>();
	private ArrayList<Character> fourthRank = new ArrayList<Character>();
	private ArrayList<Character> fifthRank = new ArrayList<Character>();
	private ArrayList<Character> sixthRank = new ArrayList<Character>();
	private ArrayList<Pawn> seventhRank = new ArrayList<Pawn>();
	private ArrayList<Character> eighthRank = new ArrayList<Character>();
	
	void initialize(){
		for (int i = 0; i < 8; i++){
			secondRank.add(new Pawn());
			seventhRank.add(new Pawn(black, 'P'));
		}
	}
	
	int getNumberOfPieces(){
		return 16;
	}
	
	void add(Pawn pawn){
		pieces.add(pawn);
	}
	
	ArrayList<Pawn> getPieces(){
		return pieces;
	}
	
	String getSecondRank(){
		StringBuilder buffer = new StringBuilder();
		
		for (Pawn pawn : secondRank) {
			buffer.append(pawn.getCharacterRepresentation());
		}
		
		return buffer.toString();
	}

	String getSeventhRank(){
		StringBuilder buffer = new StringBuilder();
		
		for (Pawn pawn : seventhRank) {
			buffer.append(pawn.getCharacterRepresentation());
		}
		
		return buffer.toString();
	}	
	
	String getEmptyRank(){
		StringBuilder buffer = new StringBuilder();
		
		for (int i = 0; i < 8; i++) {
			buffer.append('.');
		}
		
		return buffer.toString();		
	}
	
	void printBoard(){
		System.out.println(getEmptyRank());
		System.out.println(getSeventhRank());
		System.out.println(getEmptyRank());
		System.out.println(getEmptyRank());
		System.out.println(getEmptyRank());
		System.out.println(getEmptyRank());
		System.out.println(getSecondRank());		
		System.out.println(getEmptyRank());
	}
}