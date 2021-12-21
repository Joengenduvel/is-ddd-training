package chess.businessRules;

import chess.Move;
import chess.pieces.ChessPiece;
import ddd.core.businessRules.BusinessRule;
import ddd.core.businessRules.BusinessRuleViolation;

import java.util.ArrayList;
import java.util.List;

public class ValidRuleOnPieceLevel extends BusinessRule {

    private final ChessPiece chessPiece;
    private final Move move;

    public ValidRuleOnPieceLevel(ChessPiece chessPiece, Move move) {
        this.chessPiece = chessPiece;
        this.move = move;
    }

    @Override
    public List<BusinessRuleViolation> CheckRule() {
        List<BusinessRuleViolation> violations = new ArrayList<>();

        if (chessPiece == null) {
            violations.add(new PieceNotFound());
            return violations;
        }

        if (!chessPiece.isValidMove(move)) {
            violations.add(new IllegalMove(move, chessPiece));
        }

        return violations;
    }
}
