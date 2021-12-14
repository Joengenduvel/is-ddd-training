package chess;

import chess.pieces.Bishop;
import chess.pieces.ChessPiece;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;
import ddd.core.AggregateRoot;
import ddd.core.DomainEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChessGame extends AggregateRoot<ChessGameId> {
    private final ChessBoard board;

    public ChessGame(ChessGameId id, Map<BoardPosition, ChessPiece> pieces) {
        super(id);
        this.board = new ChessBoard(pieces, new ArrayList<>(0));
    }

    public ChessGame(ChessGameId gameId) {
        this(gameId, new HashMap<>() {{
            put(new BoardPosition('a', (short) 1), new Rook(ChessColor.WHITE));
            put(new BoardPosition('b', (short) 1), new Knight(ChessColor.WHITE));
            put(new BoardPosition('c', (short) 1), new Bishop(ChessColor.WHITE));
            put(new BoardPosition('d', (short) 1), new King(ChessColor.WHITE));
            put(new BoardPosition('e', (short) 1), new Queen(ChessColor.WHITE));
            put(new BoardPosition('f', (short) 1), new Bishop(ChessColor.WHITE));
            put(new BoardPosition('g', (short) 1), new King(ChessColor.WHITE));
            put(new BoardPosition('h', (short) 1), new Rook(ChessColor.WHITE));
            put(new BoardPosition('a', (short) 2), new Pawn(ChessColor.WHITE));
            put(new BoardPosition('b', (short) 2), new Pawn(ChessColor.WHITE));
            put(new BoardPosition('c', (short) 2), new Pawn(ChessColor.WHITE));
            put(new BoardPosition('d', (short) 2), new Pawn(ChessColor.WHITE));
            put(new BoardPosition('e', (short) 2), new Pawn(ChessColor.WHITE));
            put(new BoardPosition('f', (short) 2), new Pawn(ChessColor.WHITE));
            put(new BoardPosition('g', (short) 2), new Pawn(ChessColor.WHITE));
            put(new BoardPosition('h', (short) 2), new Pawn(ChessColor.WHITE));
            put(new BoardPosition('a', (short) 8), new Rook(ChessColor.BLACK));
            put(new BoardPosition('b', (short) 8), new Knight(ChessColor.BLACK));
            put(new BoardPosition('c', (short) 8), new Bishop(ChessColor.BLACK));
            put(new BoardPosition('d', (short) 8), new King(ChessColor.BLACK));
            put(new BoardPosition('e', (short) 8), new Queen(ChessColor.BLACK));
            put(new BoardPosition('f', (short) 8), new Bishop(ChessColor.BLACK));
            put(new BoardPosition('g', (short) 8), new King(ChessColor.BLACK));
            put(new BoardPosition('h', (short) 8), new Rook(ChessColor.BLACK));
            put(new BoardPosition('a', (short) 8), new Pawn(ChessColor.BLACK));
            put(new BoardPosition('b', (short) 7), new Pawn(ChessColor.BLACK));
            put(new BoardPosition('c', (short) 7), new Pawn(ChessColor.BLACK));
            put(new BoardPosition('d', (short) 7), new Pawn(ChessColor.BLACK));
            put(new BoardPosition('e', (short) 7), new Pawn(ChessColor.BLACK));
            put(new BoardPosition('f', (short) 7), new Pawn(ChessColor.BLACK));
            put(new BoardPosition('g', (short) 7), new Pawn(ChessColor.BLACK));
            put(new BoardPosition('h', (short) 7), new Pawn(ChessColor.BLACK));
        }});
    }

    @Override
    protected void when(DomainEvent domainEvent) {

    }
}
