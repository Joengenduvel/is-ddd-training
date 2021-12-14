package chess.businessRules;

import chess.BoardPosition;
import chess.pieces.ChessPiece;
import ddd.core.businessRules.BusinessRule;
import ddd.core.businessRules.BusinessRuleViolation;

import java.util.List;

public class ValidMoveRule extends BusinessRule {
    private final ChessPiece chessPiece;
    private final BoardPosition to;
    public ValidMoveRule(ChessPiece chessPiece, BoardPosition to) {
        this.chessPiece = chessPiece;
        this.to = to;
    }

    @Override
    public List<BusinessRuleViolation> CheckRule() {
        if(!chessPiece.canMoveTo(to))
            return List.of(new InvalidMove());
        return null;
    }
}
