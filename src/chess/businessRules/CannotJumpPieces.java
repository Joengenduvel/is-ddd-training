package chess.businessRules;

import chess.pieces.ChessPiece;
import ddd.core.businessRules.BusinessRuleViolation;

public class CannotJumpPieces extends BusinessRuleViolation {
    private final ChessPiece chessPiece;

    public CannotJumpPieces(ChessPiece chessPiece) {
        super();
        this.chessPiece = chessPiece;
    }

    @Override
    public String toString() {
        return chessPiece + " cannot jum pieces";
    }
}
