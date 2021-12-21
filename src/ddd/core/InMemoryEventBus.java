package ddd.core;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryEventBus implements EventBus{

    public final static EventBus INSTANCE = new InMemoryEventBus();

    ConcurrentHashMap<Class<? extends DomainEvent<?>>, List<EventHandler<? extends DomainEvent<? extends AggregateIdentifier>>>> listeners;

    private InMemoryEventBus() {
        this.listeners = new ConcurrentHashMap<>();
    }

    @Override
    public <T extends DomainEvent<? extends AggregateIdentifier>> void publish(T domainEvent) {
        List<EventHandler<? extends DomainEvent<? extends AggregateIdentifier>>> eventHandlers = listeners.get(domainEvent.getClass());
        if(eventHandlers != null){
            for(var handler:eventHandlers){
                ((EventHandler<T>)handler).handle(domainEvent);
            }
        }
    }

    @Override
    public <T extends DomainEvent<? extends AggregateIdentifier>> void subscribe(Class<T> eventType, EventHandler<T> eventListener) {
        if(!listeners.containsKey(eventType)){
            listeners.put(eventType, Arrays.asList(eventListener));
        }else{
            listeners.get(eventType).add(eventListener);
        }
    }
}
