package chess;

import ddd.core.ValueObject;

import java.util.UUID;

public class BoardId extends ValueObject {
    private final UUID id;

    public BoardId(UUID uuid) {
        this.id = uuid;
    }

    public UUID getId() {
        return id;
    }

    @Override
    protected Object[] GetAtomicValues() {
        return new Object[]{id};
    }
}
