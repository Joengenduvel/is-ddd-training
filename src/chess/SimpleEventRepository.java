package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ddd.core.AggregateIdentifier;
import ddd.core.DomainEvent;
import ddd.core.EventRepository;

public class SimpleEventRepository implements EventRepository<DomainEvent<ChessGameId>> {

    private final Map<AggregateIdentifier, List<DomainEvent<ChessGameId>>> events;

    public SimpleEventRepository() {
        events = new HashMap<>();
    }

    @Override
    public void addEvent(final DomainEvent<ChessGameId> domainEvent) {
        events.getOrDefault(domainEvent.getId(), new ArrayList<>()).add(domainEvent);
    }

    @Override
    public List<DomainEvent<ChessGameId>> getEventListById(final AggregateIdentifier id) {
        return events.getOrDefault(id, Collections.emptyList());
    }
}
