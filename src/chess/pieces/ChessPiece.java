package chess.pieces;

import chess.ChessColor;
import chess.Move;
import ddd.core.ValueObject;

public abstract class ChessPiece extends ValueObject {

    private final ChessColor color;

    public ChessPiece(ChessColor color) {
        this.color = color;
    }

    @Override
    protected Object[] GetAtomicValues() {
        return new Object[0];
    }

    public ChessColor getColor() {
        return color;
    }

    public abstract boolean isValidMove(final Move move);
}
