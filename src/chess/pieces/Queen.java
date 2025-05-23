package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        checkDirection(mat, -1, 0);  // above
        checkDirection(mat, 1, 0);   // below
        checkDirection(mat, 0, -1);  // left
        checkDirection(mat, 0, 1);   // right
        checkDirection(mat, -1, -1); // northwest
        checkDirection(mat, -1, 1);  // northeast
        checkDirection(mat, 1, -1);  // southwest
        checkDirection(mat, 1, 1);   // southeast

        return mat;
    }

    private void checkDirection(boolean[][] mat, int rowIncrement, int columnIncrement) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() + rowIncrement, position.getColumn() + columnIncrement);

        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + rowIncrement, p.getColumn() + columnIncrement);
        }

        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }
}
