package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	private static final int MIN_ROWS = 1;
	private static final int MIN_COLUMNS = 1;
	private static final String ERROR_POSITION_NOT_ON_BOARD = "Position not on the board";
	private static final String ERROR_CREATING_BOARD = "Error creating board: there must be at least 1 row and 1 column";
	private static final String ERROR_POSITION_OCCUPIED = "There is already a piece on position ";

	public Board(int rows, int columns) {
		if (rows < MIN_ROWS || columns < MIN_COLUMNS) {
			throw new BoardException(ERROR_CREATING_BOARD);
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException(ERROR_POSITION_NOT_ON_BOARD);
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException(ERROR_POSITION_NOT_ON_BOARD);
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException(ERROR_POSITION_OCCUPIED + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException(ERROR_POSITION_NOT_ON_BOARD);
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException(ERROR_POSITION_NOT_ON_BOARD);
		}
		return piece(position) != null;
	}
}
