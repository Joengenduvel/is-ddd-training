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

        Map<BoardPosition, ChessPiece> pieces = new HashMap<>();
        pieces.put(new BoardPosition('a',(short)1),new Rook(ChessColor.WHITE));
        pieces.put(new BoardPosition('b',(short)1),new Knight(ChessColor.WHITE));
        pieces.put(new BoardPosition('c',(short)1),new Bishop(ChessColor.WHITE));
        pieces.put(new BoardPosition('d',(short)1),new King(ChessColor.WHITE));
        pieces.put(new BoardPosition('e',(short)1),new Queen(ChessColor.WHITE));
        pieces.put(new BoardPosition('f',(short)1),new Bishop(ChessColor.WHITE));
        pieces.put(new BoardPosition('g',(short)1),new King(ChessColor.WHITE));
        pieces.put(new BoardPosition('h',(short)1),new Rook(ChessColor.WHITE));
        pieces.put(new BoardPosition('a',(short)2),new Pawn(ChessColor.WHITE));
        pieces.put(new BoardPosition('b',(short)2),new Pawn(ChessColor.WHITE));
        pieces.put(new BoardPosition('c',(short)2),new Pawn(ChessColor.WHITE));
        pieces.put(new BoardPosition('d',(short)2),new Pawn(ChessColor.WHITE));
        pieces.put(new BoardPosition('e',(short)2),new Pawn(ChessColor.WHITE));
        pieces.put(new BoardPosition('f',(short)2),new Pawn(ChessColor.WHITE));
        pieces.put(new BoardPosition('g',(short)2),new Pawn(ChessColor.WHITE));
        pieces.put(new BoardPosition('h',(short)2),new Pawn(ChessColor.WHITE));


        pieces.put(new BoardPosition('a',(short)8),new Rook(ChessColor.BLACK));
        pieces.put(new BoardPosition('b',(short)8),new Knight(ChessColor.BLACK));
        pieces.put(new BoardPosition('c',(short)8),new Bishop(ChessColor.BLACK));
        pieces.put(new BoardPosition('d',(short)8),new King(ChessColor.BLACK));
        pieces.put(new BoardPosition('e',(short)8),new Queen(ChessColor.BLACK));
        pieces.put(new BoardPosition('f',(short)8),new Bishop(ChessColor.BLACK));
        pieces.put(new BoardPosition('g',(short)8),new King(ChessColor.BLACK));
        pieces.put(new BoardPosition('h',(short)8),new Rook(ChessColor.BLACK));
        pieces.put(new BoardPosition('a',(short)8),new Pawn(ChessColor.BLACK));
        pieces.put(new BoardPosition('b',(short)7),new Pawn(ChessColor.BLACK));
        pieces.put(new BoardPosition('c',(short)7),new Pawn(ChessColor.BLACK));
        pieces.put(new BoardPosition('d',(short)7),new Pawn(ChessColor.BLACK));
        pieces.put(new BoardPosition('e',(short)7),new Pawn(ChessColor.BLACK));
        pieces.put(new BoardPosition('f',(short)7),new Pawn(ChessColor.BLACK));
        pieces.put(new BoardPosition('g',(short)7),new Pawn(ChessColor.BLACK));
        pieces.put(new BoardPosition('h',(short)7),new Pawn(ChessColor.BLACK));
        ChessGame chessGame = new ChessGame(gameId, pieces);
    }
}
