package chess.application;

import chess.ChessColor;
import chess.ChessGame;
import chess.ChessGameId;
import chess.MakeMoveCommand;
import chess.Move;
import ddd.core.DomainEvent;
import ddd.core.EventRepository;

import java.util.List;

public class Application {
    EventRepository<DomainEvent<ChessGameId>> eventRepository;

    public void startGame(){
        ChessGame chessGame = getGameById(new ChessGameId());

        chessGame.start();
    }

    public void makeMove(MakeMoveCommand command){
        ChessGame chessGame = getGameById(command.getGameId());
        chessGame.makeMove(ChessColor.WHITE,null);
    }

    private ChessGame getGameById(ChessGameId id) {
        ChessGame chessGame = new ChessGame(id);
        List<DomainEvent<ChessGameId>> pastEvents = eventRepository.getEventListById(chessGame.getId());
        chessGame.build(pastEvents);
        return chessGame;
    }
}
