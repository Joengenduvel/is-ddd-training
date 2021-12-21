package chess.application;

import chess.ChessGameId;
import chess.PlayerId;
import ddd.core.Command;
import lombok.Getter;

@Getter
public class JoinCommand extends Command<ChessGameId> {
    private final PlayerId playerId;

    public JoinCommand(ChessGameId id, PlayerId playerId) {
        super(id);
        this.playerId = playerId;
    }
}
