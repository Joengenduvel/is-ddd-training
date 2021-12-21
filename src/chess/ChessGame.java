package chess;

import chess.businessRules.ValidRuleOnBoardLevel;
import chess.businessRules.ValidRuleOnGameLevel;
import chess.businessRules.ValidRuleOnPieceLevel;
import chess.events.MoveMade;
import chess.pieces.Bishop;
import chess.pieces.ChessPiece;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;
import ddd.core.EventSourcedAggregate;
import ddd.core.EventSourcingHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChessGame extends EventSourcedAggregate<ChessGameId> {

    private final Map<BoardPosition, ChessPiece> pieces;

    public ChessGame(ChessGameId id, Map<BoardPosition, ChessPiece> pieces) {
        super(id);
        this.pieces = new HashMap<>(pieces);
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
            put(new BoardPosition('a', (short) 7), new Pawn(ChessColor.BLACK));
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
    @SuppressWarnings("rawtypes")
    public Map<Class, EventSourcingHandler> getHandlers() {
    //public <E extends EventSourcedAggregate<ChessGameId>> Map<Class<?>, EventSourcingHandler<E, DomainEvent<ChessGameId>>> getHandlers() {
        return new HashMap<>(){{
            put(MoveMade.class, moveMade());
        }};
    }

    private static EventSourcingHandler<ChessGame, MoveMade> moveMade() {
        return (a, e) -> {
            ChessPiece piece = a.pieces.remove(e.getCurrentPosition());
            a.pieces.put(e.getTargetPosition(), piece);

            return a;
        };
    }

    @Override
    public EventSourcedAggregate<ChessGameId> initialize() {
        return null;
    }

    public Map<BoardPosition, ChessPiece> getPieces() {
        return Collections.unmodifiableMap(pieces);
    }

    public boolean makeMove(final ChessColor color, final Move move){
        ChessPiece chessPiece = pieces.get(move.getFrom());
        ValidRuleOnPieceLevel validRuleOnPieceLevel = new ValidRuleOnPieceLevel(chessPiece, move);
        ValidRuleOnBoardLevel validRuleOnBoardLevel = new ValidRuleOnBoardLevel(chessPiece, move, pieces);
        ValidRuleOnGameLevel validRuleOnGameLevel = new ValidRuleOnGameLevel();

        validRuleOnPieceLevel.And(validRuleOnBoardLevel).And(validRuleOnGameLevel).ThrowIfNotSatisfied();

        MoveMade moveMade = new MoveMade(this.getId(), chessPiece, move.getFrom(), move.getTo());
        eventProcessor.raise(moveMade);

        // remove the pieces involved futurePieces.remove()
        // Add the new positions
        return true;
    }

    public void start() {
        
    }
}
