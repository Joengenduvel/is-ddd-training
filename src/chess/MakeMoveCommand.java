package chess;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MakeMoveCommand {

    private final ChessGameId chessGameId;
    private final PlayerId playerId;
    private final BoardPosition from;
    private final BoardPosition to;
}
