package chess;

import java.util.*;
import chess.pieces.*;
import util.StringUtil;

public class Board {
	
	private ArrayList<Piece> blackPieces = new ArrayList<Piece>();
	private ArrayList<Piece> whitePieces = new ArrayList<Piece>();
	private ArrayList<ArrayList<Piece>> board = new ArrayList<ArrayList<Piece>>();
	
	void initialize(){
		createBoard();
		buildBoard();	
	}
	
	ArrayList<ArrayList<Piece>> getBoard(){
		return board;
	}
	
	void createBoard(){
		
		for (int i = 0; i < 8; i++){
			board.add(new ArrayList<Piece>());
			for (int j = 0; j < 8; j++){
				board.get(i).add(Piece.noPiece());
			}
		}
	}
	
	void buildBoard(){
		
		addPiece(board.get(0), 0, Piece.createWhiteRook());
		addPiece(board.get(0), 1, Piece.createWhiteKnight());
		addPiece(board.get(0), 2, Piece.createWhiteBishop());
		addPiece(board.get(0), 3, Piece.createWhiteQueen());
		addPiece(board.get(0), 4, Piece.createWhiteKing());
		addPiece(board.get(0), 5, Piece.createWhiteBishop());
		addPiece(board.get(0), 6, Piece.createWhiteKnight());
		addPiece(board.get(0), 7, Piece.createWhiteRook());
		
		for (int i = 0; i < 8; i++){
			addPiece(board.get(1), i, Piece.createWhitePawn());
			addPiece(board.get(6), i, Piece.createBlackPawn());
		}

		addPiece(board.get(7), 0, Piece.createBlackRook());
		addPiece(board.get(7), 1, Piece.createBlackKnight());
		addPiece(board.get(7), 2, Piece.createBlackBishop());
		addPiece(board.get(7), 3, Piece.createBlackQueen());
		addPiece(board.get(7), 4, Piece.createBlackKing());
		addPiece(board.get(7), 5, Piece.createBlackBishop());
		addPiece(board.get(7), 6, Piece.createBlackKnight());
		addPiece(board.get(7), 7, Piece.createBlackRook());
		
	}

	void addPiece(ArrayList<Piece> rank, int index, Piece piece){
		if (piece.getColor() == Piece.Color.BLACK) blackPieces.add(piece);
		if (piece.getColor() == Piece.Color.WHITE) whitePieces.add(piece);
		piece.setPosition(getPositionFromFileAndRank(index, board.indexOf(rank)));
		rank.set(index, piece);
	}
	
	int pieceCount(){
		return Piece.getCount();
	}
	
	ArrayList<Piece> getPieces(Piece.Color color){
		if (color == Piece.Color.BLACK) return blackPieces;
		else return whitePieces;
	}
	
	int getPieceCount(Piece.Color color, Piece.Type type){
		int count = 0;
		
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		
		if (color == Piece.Color.BLACK) pieces = blackPieces;
		if (color == Piece.Color.WHITE) pieces = whitePieces;
		
		for (Piece piece : pieces){
			if (piece.getType() == type)
				count++;
		}
		
		return count;
	}
	
	double getStrength(Piece.Color color){
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		double strength = 0.0;
		
		if (color == Piece.Color.BLACK) pieces = blackPieces;
		if (color == Piece.Color.WHITE) pieces = whitePieces;
		
		for (Piece piece : pieces){
			strength += getPieceStrength(piece);
		}
		
		Collections.sort(pieces);
		
		return strength;
	}

	// void setPieceStrength(Piece piece){
		// piece.setStrength(getPieceStrength(piece));
	// }
	
	double getPieceStrength(Piece piece){
		double strength = 0.0;
		
		if (piece.getType() == Piece.Type.QUEEN) 
			strength = 9.0;
		else if (piece.getType() == Piece.Type.ROOK)
			strength = 5.0;
		else if (piece.getType() == Piece.Type.BISHOP)
			strength = 3.0;
		else if (piece.getType() == Piece.Type.KNIGHT) 
			strength = 2.5;
		else if (piece.getType() == Piece.Type.PAWN && !isOnlyPawnInFile(piece)) 
			strength = 1.0;
		else if (piece.getType() == Piece.Type.PAWN && isOnlyPawnInFile(piece))
			strength = 0.5;

		piece.setStrength(strength);
		return strength;
	}
	
	boolean isOnlyPawnInFile(Piece pawn){
		int count = 0;
		String position = pawn.getPosition(); // This returns null, which makes the next line fail
		int file = getFileIndex(position.charAt(0));
		
		for (int i = 0; i < 8; i++){
			if (board.get(i).get(file).getType() == Piece.Type.PAWN) count++;
		}
		
		return count > 1;
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
		return StringUtil.appendNewLine(getRank(board.get(7))) + 
			   StringUtil.appendNewLine(getRank(board.get(6))) + 
			   blankRank + blankRank + blankRank + blankRank + 
			   StringUtil.appendNewLine(getRank(board.get(1))) + 
			   StringUtil.appendNewLine(getRank(board.get(0)));
	}
	
	String getRank(ArrayList<Piece> rank){
		StringBuilder buffer = new StringBuilder();
		
		for (Piece piece : rank) {
			buffer.append(piece.getRepresentation());
		}
		
		return buffer.toString();
	}
	
	Piece getPieceAt(String position){
		char file = position.charAt(0);
		int rank = Character.getNumericValue(position.charAt(1));
		ArrayList<Piece> rankChoice = getRankChoice(rank);
		return rankChoice.get(getFileIndex(file));
	}
	
	void setPieceAt(String position, Piece piece){
		piece.setPosition(position);
		int file = getFileIndex(position.charAt(0));
		int rank = Character.getNumericValue(position.charAt(1));
		ArrayList<Piece> rankChoice = getRankChoice(rank);
		
		if (piece.getColor() == Piece.Color.BLACK) blackPieces.add(piece); // These two lines will cause problems when pieces are being moved rather than added - e.g. more than 2 black rooks in the list
		if (piece.getColor() == Piece.Color.WHITE) whitePieces.add(piece); // I will probably have movePieceTo() as well as setPieceAt() methods but I want to see what Jeff suggests
		
		getStrength(piece.getColor());
		piece.setStrength(getPieceStrength(piece)); // This works for individual pieces but struggles when it comes to the pawn evaluation
		rankChoice.set(file, piece);
	}
	
	private ArrayList<Piece> getRankChoice(int rank){
		if (rank == 8) return board.get(7);
		if (rank == 7) return board.get(6);
		if (rank == 6) return board.get(5);
		if (rank == 5) return board.get(4);
		if (rank == 4) return board.get(3);
		if (rank == 3) return board.get(2);
		if (rank == 2) return board.get(1);
		return board.get(0);
	}
	
	private int getFileIndex(char file){
		if (file == 'a') return 0;
		if (file == 'b') return 1;
		if (file == 'c') return 2;
		if (file == 'd') return 3;
		if (file == 'e') return 4;
		if (file == 'f') return 5;
		if (file == 'g') return 6;
		return 7;
	}
	
	private String getPositionFromFileAndRank(int file, int rank){
		StringBuilder buffer = new StringBuilder();
		
		switch(file){
			case 0: buffer.append("a");
			case 1: buffer.append("b");
			case 2: buffer.append("c");
			case 3: buffer.append("d");
			case 4: buffer.append("e");
			case 5: buffer.append("f");
			case 6: buffer.append("g");
			case 7: buffer.append("h");
		}
		
		switch(rank){
			case 0: buffer.append("1");
			case 1: buffer.append("2");
			case 2: buffer.append("3");
			case 3: buffer.append("4");
			case 4: buffer.append("5");
			case 5: buffer.append("6");
			case 6: buffer.append("7");
			case 7: buffer.append("8");			
		}
		
		return buffer.toString();
	}
}