package chess.moves;

/**
 * Represents a move that occurs in a straight line, such as horizontal to the right side or diagonal to the top right
 * corder of the board.
 */
public class SimpleDirectionalMove {

    private final Direction direction;
    private final short amountOfSquares;

    public SimpleDirectionalMove(Direction direction, short amountOfSquares) {
        this.direction = direction;
        this.amountOfSquares = amountOfSquares;
    }

    public Direction getDirection() {
        return direction;
    }

    public short getAmountOfSquares() {
        return amountOfSquares;
    }

    public enum Direction {

        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }
}
