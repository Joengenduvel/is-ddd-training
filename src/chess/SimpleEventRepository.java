package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ddd.core.AggregateIdentifier;
import ddd.core.DomainEvent;
import ddd.core.EventRepository;

public class SimpleEventRepository implements EventRepository<DomainEvent<ChessGameId>, ChessGameId> {

    private final Map<AggregateIdentifier, List<DomainEvent<ChessGameId>>> events;

    public SimpleEventRepository() {
        events = new HashMap<>();
    }

    @Override
    public void addEvent(final DomainEvent<ChessGameId> domainEvent) {
        events.putIfAbsent(domainEvent.getId(), new ArrayList<>());
        events.get(domainEvent.getId()).add(domainEvent);
    }

    @Override
    public List<DomainEvent<ChessGameId>> getEventListById(final ChessGameId id) {
        return events.getOrDefault(id, Collections.emptyList());
    }
}
