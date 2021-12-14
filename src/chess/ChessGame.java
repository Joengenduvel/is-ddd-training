package chess;

import chess.pieces.ChessPiece;
import ddd.core.AggregateRoot;
import ddd.core.DomainEvent;

import java.util.ArrayList;
import java.util.Map;

public class ChessGame extends AggregateRoot <ChessGameId> {
    private final ChessBoard board;

    public ChessGame(ChessGameId id, Map<BoardPosition, ChessPiece> pieces) {
        super(id);
        this.board = new ChessBoard(pieces, new ArrayList<>(0));
    }

    @Override
    protected void when(DomainEvent domainEvent) {

    }
}
