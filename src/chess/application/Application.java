package chess.application;

import chess.ChessColor;
import chess.ChessGame;
import chess.ChessGameId;
import chess.MakeMoveCommand;
import chess.Move;
import chess.SimpleEventRepository;
import ddd.core.DomainEvent;
import ddd.core.EventRepository;

import java.util.List;

public class Application {
    EventRepository<DomainEvent<ChessGameId>, ChessGameId> eventRepository = new SimpleEventRepository();

    public void startGame(){
        ChessGame chessGame = getGameById(new ChessGameId());

        chessGame.start();
    }

    public void makeMove(final MakeMoveCommand command){
        ChessGame chessGame = getGameById(command.getChessGameId());

        Move move = new Move(
                command.getFrom(),
                command.getTo()
        );

        chessGame.makeMove(ChessColor.WHITE, move);
    }

    private ChessGame getGameById(ChessGameId id) {
        ChessGame chessGame = new ChessGame(id);
        List<DomainEvent<ChessGameId>> pastEvents = eventRepository.getEventListById(chessGame.getId());
        chessGame.build(pastEvents);
        return chessGame;
    }
}
