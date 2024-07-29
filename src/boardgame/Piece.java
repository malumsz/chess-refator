package boardgame;

public abstract class Piece {

    protected Position position;
    private Board board;

    private static final int FIRST_ROW_INDEX = 0;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = FIRST_ROW_INDEX; i < mat.length; i++) {
            if (hasPossibleMoveInRow(mat, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPossibleMoveInRow(boolean[][] mat, int row) {
        for (int j = FIRST_ROW_INDEX; j < mat[row].length; j++) {
            if (mat[row][j]) {
                return true;
            }
        }
        return false;
    }
}
