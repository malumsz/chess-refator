package chess;

import boardgame.Position;

public class ChessPosition {
	
	private static final char MIN_COLUMN = 'a';
	private static final char MAX_COLUMN = 'h';
	private static final int MIN_ROW = 1;
	private static final int MAX_ROW = 8;

	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if (column < MIN_COLUMN || column > MAX_COLUMN || row < MIN_ROW || row > MAX_ROW) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(MAX_ROW - row, column - MIN_COLUMN);
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)(MIN_COLUMN + position.getColumn()), MAX_ROW - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
