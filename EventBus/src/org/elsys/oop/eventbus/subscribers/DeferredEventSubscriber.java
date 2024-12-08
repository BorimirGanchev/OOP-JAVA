package org.elsys.oop.eventbus.subscribers;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

import org.elsys.oop.eventbus.events.Event;

public class DeferredEventSubscriber<T extends Event<?>> implements Subscriber<T>, Iterable<T> {
    private final Queue<T> eventQueue;

    public DeferredEventSubscriber() {
        eventQueue = new PriorityQueue<>(new Comparator<T>() {
            @Override
            public int compare(T e1, T e2) {
                int priorityComparison = Integer.compare(e1.getPriority(), e2.getPriority());
                if (priorityComparison != 0) {
                    return priorityComparison;
                }
                return e1.getTimestamp().compareTo(e2.getTimestamp());
            }
        });
    }

    @Override
    public void onEvent(T event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        eventQueue.add(event);
    }

    @Override
    public Iterator<T> iterator() {
        return eventQueue.iterator();
    }

    public boolean isEmpty() {
        return eventQueue.isEmpty();
    }
}