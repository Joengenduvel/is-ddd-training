package chess;

import chess.BoardPosition;
import chess.Move;

public class CastlingMove extends Move {

    public CastlingMove(BoardPosition from, BoardPosition to) {
        super(from, to);
    }
}
