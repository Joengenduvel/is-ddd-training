package chess.pieces;

import chess.ChessColor;
import chess.Move;

public class Queen  extends ChessPiece{

    public Queen(ChessColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Move move) {
        return false;
    }
}
