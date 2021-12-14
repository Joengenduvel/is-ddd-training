package chess.moves;

/**
 * Represents a move that occurs in some sort of shape, such as the 'L' shape that can be performed by the knight.
 */
public class ShapedMove {

    private final short columnIncrement;
    private final short rowIncrement;

    public ShapedMove(short columnIncrement, short rowIncrement) {
        this.columnIncrement = columnIncrement;
        this.rowIncrement = rowIncrement;
    }

    public short getColumnIncrement() {
        return columnIncrement;
    }

    public short getRowIncrement() {
        return rowIncrement;
    }
}
