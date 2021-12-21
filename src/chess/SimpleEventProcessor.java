package chess;

import ddd.core.AggregateIdentifier;
import ddd.core.DomainEvent;
import ddd.core.EventBus;
import ddd.core.EventProcessor;
import ddd.core.InMemoryEventBus;

public class SimpleEventProcessor implements EventProcessor<ChessGameId> {

    private static final SimpleEventProcessor INSTANCE = new SimpleEventProcessor(
            new SimpleEventRepository()
    );

    private final SimpleEventRepository repository;
    private final EventBus eventBus = InMemoryEventBus.INSTANCE;

    public SimpleEventProcessor(SimpleEventRepository repository) {
        this.repository = repository;
    }

    public static SimpleEventProcessor getInstance() {
        return INSTANCE;
    }

    @Override
    public void raise(final DomainEvent<ChessGameId> event) {
        repository.addEvent(event);
        eventBus.publish(event);
    }
}
