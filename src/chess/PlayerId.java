package chess;

import ddd.core.ValueObject;

import java.util.UUID;

public class PlayerId extends ValueObject {
    private final UUID id;

    public PlayerId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    protected Object[] GetAtomicValues() {
        return new Object[]{};
    }
}
