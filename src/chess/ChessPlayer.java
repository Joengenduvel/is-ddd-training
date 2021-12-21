package chess;

public class ChessPlayer {
    private final PlayerId id;
    private final ChessColor color;

    public ChessPlayer(PlayerId id, ChessColor color) {
        this.id = id;
        this.color = color;
    }
}
