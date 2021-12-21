package ddd.core;


public interface EventProcessor<T extends AggregateIdentifier> {
    /**
     * Facade to transactionally proces the domain event
     * @param event
     * @param <A>
     */
    void raise(DomainEvent<T> event);
}
