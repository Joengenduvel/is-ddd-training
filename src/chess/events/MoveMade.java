package chess.events;

import chess.BoardPosition;
import chess.ChessGameId;
import chess.pieces.ChessPiece;
import ddd.core.DomainEvent;

public class MoveMade extends DomainEvent<ChessGameId> {
    private final ChessPiece piece;
    private final BoardPosition currentPosition;
    private final BoardPosition targetPosition;

    public MoveMade(ChessGameId gameId, ChessPiece piece, BoardPosition currentPosition, BoardPosition targetPosition) {
        super(gameId);
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
