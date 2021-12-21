package chess.events;

import chess.ChessColor;
import chess.ChessGameId;
import chess.PlayerId;
import ddd.core.DomainEvent;
import lombok.Getter;

@Getter
public class PlayerJoined extends DomainEvent<ChessGameId> {
    private final PlayerId playerId;
    private final ChessColor color;

    public PlayerJoined(ChessGameId id, PlayerId playerId, ChessColor color) {
        super(id);
        this.playerId = playerId;
        this.color = color;
    }
}
