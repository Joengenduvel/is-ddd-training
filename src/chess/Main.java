package chess;

import ddd.core.businessRules.BusinessRuleViolationException;

public class Main {

    public static void main(final String[] args) {
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
            System.out.println("Successfully blocked invalid move for location without piece");
        }
    }

    private static Move moveMostLeftPieceOfWhiteOneUp() {
        return new Move(
                new BoardPosition('a', (short) 2),
                new BoardPosition('a', (short) 3)
        );
    }
}
