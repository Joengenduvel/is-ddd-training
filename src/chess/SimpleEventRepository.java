package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ddd.core.AggregateIdentifier;
import ddd.core.DomainEvent;
import ddd.core.EventRepository;

public class SimpleEventRepository implements EventRepository<DomainEvent<? extends AggregateIdentifier>> {

    private final Map<AggregateIdentifier, List<DomainEvent<? extends AggregateIdentifier>>> events;

    public SimpleEventRepository() {
        events = new HashMap<>();
    }

    @Override
    public void addEvent(final DomainEvent<? extends AggregateIdentifier> domainEvent) {
        events.putIfAbsent(domainEvent.getId(), new ArrayList<>());
        events.get(domainEvent.getId()).add(domainEvent);
    }

    @Override
    public List<DomainEvent<? extends AggregateIdentifier>> getEventListById(final AggregateIdentifier id) {
        return events.getOrDefault(id, Collections.emptyList());
    }
}
