package chess;

import ddd.core.AggregateIdentifier;
import ddd.core.DomainEvent;
import ddd.core.EventBus;
import ddd.core.EventProcessor;
import ddd.core.EventRepository;
import ddd.core.InMemoryEventBus;

public class SimpleEventProcessor implements EventProcessor<ChessGameId> {

    private static final SimpleEventProcessor INSTANCE = new SimpleEventProcessor();

    private final EventRepository<DomainEvent<ChessGameId>, ChessGameId> repository;
    private final EventBus eventBus;

    private SimpleEventProcessor() {

        this.repository = SimpleEventRepository.INSTANCE;
        this.eventBus = InMemoryEventBus.INSTANCE;
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
