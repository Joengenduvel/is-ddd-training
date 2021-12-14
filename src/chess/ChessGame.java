package chess;

import ddd.core.AggregateRoot;
import ddd.core.DomainEvent;

public class ChessGame extends AggregateRoot <ChessGameId> {
    private final ChessBoard board;

    public ChessGame(ChessGameId id, ChessBoard board) {
        super(id);
        this.board = board;
    }

    @Override
    protected void when(DomainEvent domainEvent) {

    }
}
