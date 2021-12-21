package chess;

import ddd.core.AggregateIdentifier;
import ddd.core.DomainEvent;
import ddd.core.EventProcessor;

public class SimpleEventProcessor implements EventProcessor {

    private static final SimpleEventProcessor INSTANCE = new SimpleEventProcessor(
            new SimpleEventRepository()
    );

    private final SimpleEventRepository repository;
    // TODO - Add event bus

    public SimpleEventProcessor(SimpleEventRepository repository) {
        this.repository = repository;
    }

    public static SimpleEventProcessor getInstance() {
        return INSTANCE;
    }

    @Override
    public <A extends AggregateIdentifier> void raise(final DomainEvent<A> event) {
        repository.addEvent(event);
    }
}
