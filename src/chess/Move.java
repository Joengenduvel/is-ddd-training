package chess;

import ddd.core.ValueObject;

import java.util.ArrayList;
import java.util.List;

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

    public int getColumnDifference() {
        return to.getColumn() - from.getColumn();
    }

    public int getAbsoluteColumnDifference() {
        return Math.abs(getColumnDifference());
    }

    public int getAbsoluteRowDifference() {
        return Math.abs(getRowDifference());
    }

    @Override
    protected Object[] GetAtomicValues() {
        return new Object[]{from, to};
    }

    public List<BoardPosition> getPositionsSequence() {
        List<BoardPosition> positions = new ArrayList<>();
        if(isDiagonal()){

        }
        positions.add(to);
        return positions;
    }

    private boolean isDiagonal() {
        return getAbsoluteColumnDifference() == getAbsoluteRowDifference();
    }
}
