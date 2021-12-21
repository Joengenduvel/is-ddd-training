package chess.businessRules;

import chess.Move;
import chess.pieces.ChessPiece;
import ddd.core.businessRules.BusinessRuleViolation;

public class IllegalMove extends BusinessRuleViolation {

    private final Move move;
    private final ChessPiece piece;

    public IllegalMove(Move move, ChessPiece piece) {
        this.move = move;
        this.piece = piece;
    }

    public Move getMove() {
        return move;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return piece + " cannot make " + move;
    }
}
