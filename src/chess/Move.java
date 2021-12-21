package chess;

import ddd.core.ValueObject;

public class Move extends ValueObject {

    private final BoardPosition from;
    private final BoardPosition to;

    public Move(BoardPosition from, BoardPosition to) {
        this.from = from;
        this.to = to;
    }

    public BoardPosition getFrom() {
        return from;
    }

    public BoardPosition getTo() {
        return to;
    }

    public int getRowDifference() {
        return to.getRow() - from.getRow();
    }

    public int getAbsoluteColumnDifference() {
        return Math.abs(to.getColumn() - from.getColumn());
    }

    public int getAbsoluteRowDifference() {
        return Math.abs(to.getRow() - from.getRow());
    }

    @Override
    protected Object[] GetAtomicValues() {
        return new Object[]{from, to};
    }
}
