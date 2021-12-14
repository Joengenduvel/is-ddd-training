package ddd.core;

import chess.BoardPosition;
import chess.ChessColor;
import chess.ChessGame;
import chess.ChessGameId;
import chess.pieces.Bishop;
import chess.pieces.ChessPiece;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("CHESS JR");
        ChessGameId gameId = new ChessGameId();
        System.out.println("Starting game with ID " + gameId);

        ChessGame chessGame = new ChessGame(gameId);
    }
}
