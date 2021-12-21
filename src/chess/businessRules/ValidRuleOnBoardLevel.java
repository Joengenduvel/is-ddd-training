package chess.businessRules;

import chess.BoardPosition;
import chess.Move;
import chess.pieces.ChessPiece;
import chess.pieces.King;
import chess.pieces.Pawn;
import ddd.core.businessRules.BusinessRule;
import ddd.core.businessRules.BusinessRuleViolation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ValidRuleOnBoardLevel extends BusinessRule {

    private final ChessPiece chessPiece;
    private final Move move;
    private final Map<BoardPosition, ChessPiece> pieces;

    public ValidRuleOnBoardLevel(ChessPiece chessPiece, Move move, Map<BoardPosition, ChessPiece> pieces) {
        super();
        this.chessPiece = chessPiece;
        this.move = move;
        this.pieces = Collections.unmodifiableMap(pieces);
    }

    @Override
    public List<BusinessRuleViolation> CheckRule() {
        List<BusinessRuleViolation> violations = new ArrayList<>();
        if(chessPiece instanceof Pawn){
            if(jumpsOverPieces(move,pieces)){
                violations.add(new CannotJumpPieces(chessPiece));
            }
        }
        if(chessPiece instanceof King){
            if(jumpsOverPieces(move,pieces)){
                violations.add(new CannotJumpPieces(chessPiece));
            }
        }
        return violations;
    }

    private boolean jumpsOverPieces(Move move, Map<BoardPosition, ChessPiece> pieces) {
        List<BoardPosition> positions = move.getPositionsSequence();
        for(var position : positions){
            if(pieces.containsKey(position))
                return true;
        }
        return false;
    }
}
