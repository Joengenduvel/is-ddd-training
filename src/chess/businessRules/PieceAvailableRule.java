package chess.businessRules;

import chess.BoardPosition;
import chess.ChessBoard;
import ddd.core.businessRules.BusinessRule;
import ddd.core.businessRules.BusinessRuleViolation;

import java.util.List;

public class PieceAvailableRule extends BusinessRule {
    private final ChessBoard board;
    private final BoardPosition position;

    public PieceAvailableRule(ChessBoard board, BoardPosition position) {
        this.board = board;
        this.position = position;
    }

    @Override
    public List<BusinessRuleViolation> CheckRule() {

        if(board.getPiece(position).isEmpty())
            return List.of(new PieceNotPresentAtPosition(position));

        return null;
    }
}
