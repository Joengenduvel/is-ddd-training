package chess;

import chess.application.Application;
import chess.events.MoveMade;
import ddd.core.DomainEvent;
import ddd.core.EventBus;
import ddd.core.EventHandler;
import ddd.core.InMemoryEventBus;
import ddd.core.businessRules.BusinessRuleViolationException;

public class Main {

    public static void main(final String[] args) {
        EventBus bus = new InMemoryEventBus();

        EventHandler<MoveMade> startedEventListener = new EventHandler<MoveMade>() {
            @Override
            public void handle(MoveMade event) {
                System.out.println("Move made by ");
            }
        };
        bus.subscribe(MoveMade.class, startedEventListener);

        Application app = new Application();
        app.startGame();


        final ChessGameId gameId = new ChessGameId();
        final ChessGame game = new ChessGame(gameId);

        final BoardPosition a2 = new BoardPosition('a', (short) 2);
        final BoardPosition a3 = new BoardPosition('a', (short) 3);

        System.out.println("a2 - " + game.getPieces().get(a2));
        System.out.println("a3 - " + game.getPieces().get(a3));

        game.makeMove(ChessColor.WHITE, moveMostLeftPieceOfWhiteOneUp());

        System.out.println("a2 - " + game.getPieces().get(a2));
        System.out.println("a3 - " + game.getPieces().get(a3));

        try {
            game.makeMove(ChessColor.WHITE, moveMostLeftPieceOfWhiteOneUp());
        } catch (BusinessRuleViolationException e) {
            for( var violation : e.getViolations()){
                System.out.println(violation.toString());
            }
            System.out.println("Successfully blocked invalid move for location without piece: ");
        }



        try {
            game.makeMove(ChessColor.WHITE, moveKingForward());
        } catch (BusinessRuleViolationException e) {
            for( var violation : e.getViolations()){
                System.out.println(violation.toString());
            }
            System.out.println("Successfully blocked invalid move for destination with piece: ");
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
