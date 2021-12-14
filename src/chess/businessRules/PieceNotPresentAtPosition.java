package chess.businessRules;

import chess.BoardPosition;
import ddd.core.businessRules.BusinessRuleViolation;

public class PieceNotPresentAtPosition extends BusinessRuleViolation {
    public PieceNotPresentAtPosition(BoardPosition position) {

    }
}
