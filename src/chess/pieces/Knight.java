package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        // Define the possible moves for a Knight
        int[][] moves = {
            {-1, -2},
            {-2, -1},
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2}
        };

        // Check all possible moves
        for (int[] move : moves) {
            checkMove(mat, move[0], move[1]);
        }

        return mat;
    }

    private void checkMove(boolean[][] mat, int rowOffset, int columnOffset) {
        Position p = new Position(position.getRow() + rowOffset, position.getColumn() + columnOffset);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }
}
