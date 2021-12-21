package chess;

import chess.application.Application;
import chess.events.GameStarted;
import chess.events.MoveMade;
import chess.pieces.ChessPiece;
import ddd.core.EventBus;
import ddd.core.EventHandler;
import ddd.core.InMemoryEventBus;
import ddd.core.businessRules.BusinessRuleViolationException;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    static Application app = new Application();

    public static void main(final String[] args) {
        EventBus bus = InMemoryEventBus.INSTANCE;

        EventHandler<MoveMade> startedEventListener = new EventHandler<MoveMade>() {
            @Override
            public void handle(MoveMade event) {

                System.out.println("Move made by ");
                Map<BoardPosition, ChessPiece> pieces = app.getGameById(event.getId()).getPieces();
                for(var entry : pieces.entrySet()){
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }
            }
        };
        bus.subscribe(MoveMade.class, startedEventListener);

        AtomicReference<ChessGameId> id = new AtomicReference<>();
        bus.subscribe(GameStarted.class, event -> {
            System.out.println("Started game " + event.getId());
            id.set(event.getId());
        });
        app.startGame();


        final BoardPosition a2 = new BoardPosition('a', (short) 2);
        final BoardPosition a3 = new BoardPosition('a', (short) 3);

        ChessGame game1 = app.getGameById(id.get());

        System.out.println("a2 - " + game1.getPieces().get(a2));
        System.out.println("a3 - " + game1.getPieces().get(a3));

        app.makeMove(new MakeMoveCommand(id.get(), null, a2,a3));
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
