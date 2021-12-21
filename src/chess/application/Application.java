package chess.application;

import chess.ChessColor;
import chess.ChessGame;
import chess.ChessGameId;
import chess.Move;
import chess.SimpleEventRepository;
import ddd.core.DomainEvent;
import ddd.core.EventRepository;

import java.util.List;

public class Application {
    EventRepository<DomainEvent<ChessGameId>, ChessGameId> eventRepository = SimpleEventRepository.INSTANCE;

    public void startGame(ChessGameId id){
        ChessGame chessGame = getGameById(id);

        chessGame.start();
    }

    public void makeMove(final MakeMoveCommand command){
        ChessGame chessGame = getGameById(command.getId());

        Move move = new Move(
                command.getFrom(),
                command.getTo()
        );

        chessGame.makeMove(ChessColor.WHITE, move);
    }

    public ChessGame getGameById(ChessGameId id) {
        ChessGame chessGame = new ChessGame(id);
        List<DomainEvent<ChessGameId>> pastEvents = eventRepository.getEventListById(chessGame.getId());
        chessGame.build(pastEvents);
        return chessGame;
    }

    public void joinGame(final JoinCommand command) {
        ChessGame game = getGameById(command.getId());
        game.join(command.getPlayerId());
    }
}
