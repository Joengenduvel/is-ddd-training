package ddd.core;

/// <summary>
/// Represents an Entity in the domain (DDD).
/// </summary>
/// <typeparam name="TId">The type of the Id of the entity.</typeparam>
public abstract class Entity<TId> {

    private final TId _id;

    public Entity(TId id) {
        _id = id;
    }

    public TId get_id() {
        return _id;
    }
}