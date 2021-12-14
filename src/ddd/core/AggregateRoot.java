package ddd.core;

import java.util.ArrayList;

/// <summary>
/// Represents an aggregate-root of a domain aggregate (DDD). An aggregate-root is always an entity.
/// </summary>
/// <typeparam name="TId">The type of the Id of the entity.</typeparam>
public abstract class AggregateRoot<TId> extends Entity<TId> {

    /// <summary>
    /// The list of events that occurred while handling commands.
    /// </summary>
    private final ArrayList<DomainEvent> _events;

    public ArrayList<DomainEvent> getEvents() {
        return _events;
    }


    /// <summary>
    /// Indication whether the aggregate is replaying events (true) or not (false).
    /// </summary>
    private boolean _isRelaying = false;

    protected boolean isRelaying() {
        return _isRelaying;
    }

    /// <summary>
    /// The current version after handling any commands.
    /// </summary>
    private int _version;

    public int getVersion() {
        return _version;
    }

    /// <summary>
    /// The original version of the aggregate after replaying all events in the event-store.
    /// </summary>
    private int _originalVersion;

    public int getOriginalVersion() {
        return _originalVersion;
    }

    /// <summary>
    /// Constructor for creating an empty aggregate.
    /// </summary>
    /// <param name="id">The unique id of the aggregate-root.</param>
    public AggregateRoot(TId id)  {
        super(id);
        _originalVersion = 0;
        _version = 0;
        _events = new ArrayList<DomainEvent>();
    }

    /// <summary>
    /// Constructor for creating an aggregate of which the state is intialized by
    /// replaying the list of events specified.
    /// </summary>
    /// <param name="id">The unique Id of the aggregate.</param>
    /// <param name="events">The events to replay.</param>
    public AggregateRoot(TId id, ArrayList<DomainEvent> events) {
        this(id);
        _isRelaying = true;
        for (DomainEvent evt : _events) {
            when(evt);
            _originalVersion++;
            _version++;
        }
        _isRelaying = false;
    }

    /// <summary>
    /// Let the aggregate handle an event and save it in the list of events
    /// so it can be used outside the aggregate (persisted, published on a bus, ...).
    /// </summary>
    /// <param name="domainEevent">The event to handle.</param>
    /// <remarks>Use GetEvents to retrieve the list of events.</remarks>
    protected void raiseEvent(DomainEvent domainEvent) {
        // let the derived aggregate handle the event
        when(domainEvent);

        // save the event so it can be published outside the aggregate
        _events.add(domainEvent);
        _version += 1;
    }

    /// <summary>
    /// Clear the list of events that occurred while handling a command.
    /// </summary>
    public void ClearEvents() {
        _events.clear();
    }

    /// <summary>
    /// Handle a specific event. Derived classes should  implement this method
    ///for every event type.
    /// </summary>
    /// <param name="domainEevent">The event to handle.</param>
    /// <remarks>Because the parameter type of the specified event is dynamic,
    /// the appropriate overload of the When method is called.</remarks>
    protected abstract void when(DomainEvent domainEvent);
}
