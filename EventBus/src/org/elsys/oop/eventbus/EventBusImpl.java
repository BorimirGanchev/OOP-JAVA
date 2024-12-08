package org.elsys.oop.eventbus;

import java.time.Instant;
import java.util.*;
import org.elsys.oop.eventbus.events.Event;
import org.elsys.oop.eventbus.exeptions.MissingSubscriptionException;
import org.elsys.oop.eventbus.subscribers.Subscriber;

public class EventBusImpl implements EventBus {

    private final Map<Class<?>, List<Subscriber<?>>> subscribers = new HashMap<>();
    private final Map<Class<?>, List<Event<?>>> eventLogs = new HashMap<>();

    @Override
    public <T extends Event<?>> void subscribe(Class<T> eventType, Subscriber<? super T> subscriber) {
        if (eventType == null || subscriber == null) {
            throw new IllegalArgumentException("Event type and subscriber cannot be null");
        }
        if (!subscribers.containsKey(eventType)) {
            subscribers.put(eventType, new ArrayList<Subscriber<?>>());
        }
        subscribers.get(eventType).add(subscriber);
    }

    @Override
    public <T extends Event<?>> void unsubscribe(Class<T> eventType, Subscriber<? super T> subscriber)
            throws MissingSubscriptionException {
        if (eventType == null || subscriber == null) {
            throw new IllegalArgumentException("Event type and subscriber cannot be null");
        }
        List<Subscriber<?>> eventSubscribers = subscribers.get(eventType);
        if (eventSubscribers == null || !eventSubscribers.remove(subscriber)) {
            throw new MissingSubscriptionException("Subscriber not found for the event type");
        }
    }

    @Override
    public <T extends Event<?>> void publish(T event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        List<Subscriber<?>> eventSubscribers = subscribers.get(event.getClass());
        if (eventSubscribers != null) {
            for (Subscriber<?> subscriber : eventSubscribers) {
                @SuppressWarnings("unchecked")
                Subscriber<T> typedSubscriber = (Subscriber<T>) subscriber;
                typedSubscriber.onEvent(event);
            }
        }
        if (!eventLogs.containsKey(event.getClass())) {
            eventLogs.put(event.getClass(), new ArrayList<Event<?>>());
        }
        eventLogs.get(event.getClass()).add(event);
    }

    @Override
    public void clear() {
        subscribers.clear();
        eventLogs.clear();
    }

    @Override
    public Collection<? extends Event<?>> getEventLogs(Class<? extends Event<?>> eventType, Instant from, Instant to) {
        if (eventType == null || from == null || to == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        List<? extends Event<?>> logs = eventLogs.containsKey(eventType) ? eventLogs.get(eventType) : Collections.emptyList();
        List<Event<?>> filteredLogs = new ArrayList<>();
        for (Event<?> event : logs) {
            if (!event.getTimestamp().isBefore(from) && event.getTimestamp().isBefore(to)) {
                filteredLogs.add(event);
            }
        }
        return Collections.unmodifiableList(filteredLogs);
    }

    @Override
    public <T extends Event<?>> Collection<Subscriber<?>> getSubscribersForEvent(Class<T> eventType) {
        if (eventType == null) {
            throw new IllegalArgumentException("Event type cannot be null");
        }
        return Collections.unmodifiableList(subscribers.containsKey(eventType) ? subscribers.get(eventType) : Collections.emptyList());
    }
}