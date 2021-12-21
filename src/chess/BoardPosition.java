package chess;

import lombok.Value;

@Value
public class BoardPosition{
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
    public String toString() {
        return "" + column + row;
    }
}
