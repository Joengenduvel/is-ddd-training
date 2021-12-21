package chess.pieces;

import chess.ChessColor;
import chess.Move;

public class King extends ChessPiece {

    public King(ChessColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(final Move move) {
        final boolean isOneVertical = move.getAbsoluteRowDifference() == 1 && move.getAbsoluteColumnDifference() == 0;
        final boolean isOneHorizontal = move.getAbsoluteColumnDifference() == 1 && move.getAbsoluteRowDifference() == 0;

        return isOneVertical || isOneHorizontal;
    }
}
