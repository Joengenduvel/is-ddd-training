package chess.events;

import chess.ChessGameId;
import ddd.core.DomainEvent;

public class GameStarted extends DomainEvent<ChessGameId> {
    public GameStarted(ChessGameId id) {
        super(id);
    }
}
