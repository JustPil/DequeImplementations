package deques;

import exceptions.EmptyDequeDequeueException;

public interface DequeInterface<T> {
    void enqueueFront(T element);
    void enqueueRear(T element);
    T dequeueFront() throws EmptyDequeDequeueException;
    T dequeueRear() throws EmptyDequeDequeueException;
    boolean isFull();
    boolean isEmpty();
    int size();
    String toString();
}
