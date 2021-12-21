package chess.application;

import chess.BoardPosition;
import chess.ChessGameId;
import chess.PlayerId;
import ddd.core.Command;
import lombok.Getter;

@Getter
public class MakeMoveCommand extends Command<ChessGameId> {

    private final PlayerId playerId;
    private final BoardPosition from;
    private final BoardPosition to;

    public MakeMoveCommand(ChessGameId id, PlayerId playerId, BoardPosition from, BoardPosition to) {
        super(id);
        this.playerId = playerId;
        this.from = from;
        this.to = to;
    }
}
