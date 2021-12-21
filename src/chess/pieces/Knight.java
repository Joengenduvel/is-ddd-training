package chess.pieces;

import chess.ChessColor;
import chess.Move;

public class Knight extends ChessPiece {

    public Knight(ChessColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(final Move move) {
        return move.getAbsoluteRowDifference() == 2 && move.getAbsoluteColumnDifference() == 1;
    }
}
