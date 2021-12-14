package chess.businessRules;

import chess.pieces.ChessPiece;
import ddd.core.businessRules.BusinessRule;
import ddd.core.businessRules.BusinessRuleViolation;

import java.util.ArrayList;
import java.util.List;

public class ValidRuleOnPieceLevel extends BusinessRule {

    private ChessPiece chessPiece;

    public ValidRuleOnPieceLevel(ChessPiece chessPiece) {

        this.chessPiece = chessPiece;
    }

    @Override
    public List<BusinessRuleViolation> CheckRule() {
        List<BusinessRuleViolation> violations = new ArrayList<>();
        if(chessPiece == null)
            violations.add(new PieceNotFound());
        return null;
    }
}
