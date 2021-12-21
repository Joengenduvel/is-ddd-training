package chess.pieces;

import chess.ChessColor;
import chess.Move;

public class Bishop extends ChessPiece {

    public Bishop(ChessColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(final Move move) {
        int absColumnRange = Math.abs(move.getTo().getColumn() - move.getFrom().getColumn());
        int absRowRange = Math.abs(move.getTo().getRow() - move.getFrom().getRow());

        return absColumnRange == absRowRange;
    }
}
