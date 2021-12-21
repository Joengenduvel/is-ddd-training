package chess;

import ddd.core.AggregateIdentifier;
import ddd.core.DomainEvent;
import ddd.core.EventProcessor;

public class SimpleEventProcessor implements EventProcessor<ChessGameId> {

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
    public void raise(final DomainEvent<ChessGameId> event) {
        repository.addEvent(event);
    }
}
