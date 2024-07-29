package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // Define the possible directions for a Bishop
        int[][] directions = {
            {-1, -1}, // nw
            {-1, 1},  // ne
            {1, 1},   // se
            {1, -1}   // sw
        };

        // Check all possible directions
        for (int[] direction : directions) {
            checkDirection(mat, direction[0], direction[1]);
        }

        return mat;
    }

    private void checkDirection(boolean[][] mat, int rowDirection, int columnDirection) {
        Position p = new Position(position.getRow() + rowDirection, position.getColumn() + columnDirection);

        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + rowDirection, p.getColumn() + columnDirection);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }
}
