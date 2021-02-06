package chess.pieces;

public class Piece {
	
	final static char PAWN_REPRESENTATION = 'p';
	final static char ROOK_REPRESENTATION = 'r';
	final static char KNIGHT_REPRESENTATION = 'n';
	final static char BISHOP_REPRESENTATION = 'b';
	final static char QUEEN_REPRESENTATION = 'q';
	final static char KING_REPRESENTATION = 'k';
	static int pieceCount = 0;
	
	private enum Color {BLACK, WHITE};
	enum Type {PAWN, ROOK, KNIGHT, BISHOP, KING, QUEEN, NO_PIECE};
	Color color;
	Type type;
	private char representation;
	
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
	
	private Piece(Type type){
		this.type = type;
		this.representation = '.';
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
	
	public static Piece createWhitePawn(){
		return new Piece(Color.WHITE, Type.PAWN);
	}
	
	public static Piece createBlackPawn(){
		return new Piece(Color.BLACK, Type.PAWN);
	}
	
	public static Piece createWhiteRook(){
		return new Piece(Color.WHITE, Type.ROOK);
	}

	public static Piece createBlackRook(){
		return new Piece(Color.BLACK, Type.ROOK);
	}
	
	public static Piece createWhiteKnight(){
		return new Piece(Color.WHITE, Type.KNIGHT);
	}

	public static Piece createBlackKnight(){
		return new Piece(Color.BLACK, Type.KNIGHT);
	}
	
	public static Piece createWhiteBishop(){
		return new Piece(Color.WHITE, Type.BISHOP);
	}

	public static Piece createBlackBishop(){
		return new Piece(Color.BLACK, Type.BISHOP);
	}

	public static Piece createWhiteQueen(){
		return new Piece(Color.WHITE, Type.QUEEN);
	}

	public static Piece createBlackQueen(){
		return new Piece(Color.BLACK, Type.QUEEN);
	}	

	public static Piece createWhiteKing(){
		return new Piece(Color.WHITE, Type.KING);
	}

	public static Piece createBlackKing(){
		return new Piece(Color.BLACK, Type.KING);
	}
	
	public static Piece noPiece(){
		return new Piece(Type.NO_PIECE);
	}
	
	void setBlackChar(){
		this.representation = Character.toUpperCase(this.representation);
	}
	
	boolean isBlack(){
		return this.getColor() == Color.BLACK;
	}
	
	boolean isWhite(){
		return this.getColor() == Color.WHITE;
	}
	
	Color getColor(){
		return color;
	}
	
	Type getType(){
		return type;
	}	
}