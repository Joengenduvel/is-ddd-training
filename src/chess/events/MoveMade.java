package chess.events;

import chess.BoardPosition;
import chess.pieces.ChessPiece;
import ddd.core.DomainEvent;

public class MoveMade extends DomainEvent {

    private final ChessPiece piece;
    private final BoardPosition currentPosition;
    private final BoardPosition targetPosition;

    public MoveMade(ChessPiece piece, BoardPosition currentPosition, BoardPosition targetPosition) {
        this.piece = piece;
        this.currentPosition = currentPosition;
        this.targetPosition = targetPosition;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public BoardPosition getCurrentPosition() {
        return currentPosition;
    }

    public BoardPosition getTargetPosition() {
        return targetPosition;
    }
}
