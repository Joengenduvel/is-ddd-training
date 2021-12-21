package chess.pieces;

import chess.ChessColor;
import chess.Move;

public class Rook  extends ChessPiece{

    public Rook(ChessColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Move move) {
        return false;
    }
}
