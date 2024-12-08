package org.elsys.oop.eventbus.events;

public interface Payload<T> {

    /**
     * @return the size of the payload
     */
    int getSize();

    /**
     * @return the payload
     */
    T getPayload();

}