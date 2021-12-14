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


    @Override
    protected Object[] GetAtomicValues() {
        return new Object[]{from, to};
    }
}
