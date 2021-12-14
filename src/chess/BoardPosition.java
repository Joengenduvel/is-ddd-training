package chess;

import ddd.core.ValueObject;

public class BoardPosition extends ValueObject {
    private final char column;
    private final short row;

    public BoardPosition(char column, short row) {
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public short getRow() {
        return row;
    }

    @Override
    protected Object[] GetAtomicValues() {
        return new Object[]{column, row};
    }
}
