package chess;

import chess.application.Application;
import chess.application.JoinCommand;
import chess.application.MakeMoveCommand;
import chess.events.GameStarted;
import chess.events.MoveMade;
import chess.pieces.ChessPiece;
import ddd.core.EventBus;
import ddd.core.InMemoryEventBus;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    static Application app = new Application();
    private static EventBus bus = InMemoryEventBus.INSTANCE;

    public static void main(final String[] args) {

        AtomicReference<ChessGameId> id = new AtomicReference<>();
        id.set(new ChessGameId());
        PlayerId players[] = new PlayerId[]{new PlayerId(UUID.randomUUID()),new PlayerId(UUID.randomUUID())};

        bus.subscribe(MoveMade.class, event -> {

            System.out.println("Move made by ");
            printBoard(event.getId());
        });

        bus.subscribe(GameStarted.class, event -> {
            System.out.println("Started game " + event.getId());
        });

        JoinCommand joinCommandPlayer1 = new JoinCommand(id.get(), players[0]);
        app.joinGame(joinCommandPlayer1);

        JoinCommand joinCommandPlayer2 = new JoinCommand(id.get(), players[1]);
        app.joinGame(joinCommandPlayer2);

        app.startGame(id.get());


        final BoardPosition a2 = new BoardPosition('a', (short) 2);
        final BoardPosition a3 = new BoardPosition('a', (short) 3);

        ChessGame game1 = app.getGameById(id.get());

        System.out.println("a2 - " + game1.getPieces().get(a2));
        System.out.println("a3 - " + game1.getPieces().get(a3));

        app.makeMove(new MakeMoveCommand(id.get(), null, a2,a3));
    }

    private static void printBoard(ChessGameId id) {
        Map<BoardPosition, ChessPiece> pieces = app.getGameById(id).getPieces();
        for(var entry : pieces.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    private static Move moveKingForward() {
        return new Move(
                new BoardPosition('d', (short) 1),
                new BoardPosition('d', (short) 2)
        );
    }

    private static Move moveMostLeftPieceOfWhiteOneUp() {
        return new Move(
                new BoardPosition('a', (short) 2),
                new BoardPosition('a', (short) 3)
        );
    }
}
