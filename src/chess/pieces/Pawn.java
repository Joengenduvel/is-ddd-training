package chess.pieces;

import chess.ChessColor;
import chess.Move;

public class Pawn extends ChessPiece {

    public Pawn(ChessColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(final Move move) {
        // TODO - Column is char, therefore we probably shouldn't directly use it for calculations
        if (move.getAbsoluteColumnDifference() != 0) {
            return false;
        }

        if (move.getRowDifference() == 1 && ChessColor.WHITE.equals(getColor())) {
            return true;
        }

        return move.getRowDifference() == 0 && ChessColor.BLACK.equals(getColor());
    }
}
