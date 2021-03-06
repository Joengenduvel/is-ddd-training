package chess;

import java.util.UUID;

import ddd.core.AggregateIdentifier;
import ddd.core.ValueObject;

public class ChessGameId extends ValueObject implements AggregateIdentifier {

    private final String id;

    public ChessGameId() {
        this(UUID.randomUUID().toString());
    }

    public ChessGameId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    protected Object[] GetAtomicValues() {
        return new Object[0];
    }
}
