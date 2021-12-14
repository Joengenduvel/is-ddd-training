package chess;

import chess.businessRules.PieceAvailableRule;
import chess.businessRules.ValidMoveRule;
import chess.pieces.ChessPiece;
import ddd.core.ValueObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ChessBoard extends ValueObject {
    private final Map<BoardPosition, ChessPiece> pieces;
    private final List<Move> pastMoves;

    public ChessBoard(Map<BoardPosition, ChessPiece> pieces, List<Move> pastMoves) {
        this.pieces = pieces;
        this.pastMoves = pastMoves;
    }

    public ChessBoard makeMove(ChessColor color, Move move){
        Map<BoardPosition, ChessPiece> futurePieces = this.pieces;
        // remove the pieces involved futurePieces.remove()
        // Add the new positions
        return new ChessBoard(futurePieces, this.pastMoves);
    }


    @Override
    protected Object[] GetAtomicValues() {
        return new Object[0];
    }
}
