package dequetests;

import deques.ArrayDeque;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class ArrayDequeTests {
    private final ArrayDeque<Integer> deque = new ArrayDeque<>();

    @Test
    public void enqueueInitialElementFront() {
        deque.enqueueFront(1);
        var result = deque.size();
        Assertions.assertEquals(1, result);
    }

    @Test
    public void enqueueInitialElementRear() {
        deque.enqueueRear(1);
        var result = deque.size();
        Assertions.assertEquals(1, result);
    }

    @Test
    public void enqueueMultipleElementsFront() {
        for(int i = 0; i < 5; i++) {
            deque.enqueueFront(i);
        }
        var result = deque.size();
        Assertions.assertEquals(5, result);
    }

    @Test
    public void enqueueMultipleElementsRear() {
        for(int i = 0; i < 5; i++) {
            deque.enqueueRear(i);
        }
        var result = deque.size();
        Assertions.assertEquals(5, result);
    }

    @Test
    public void dequeueFrontElementResultingInEmptyDeque() {
        deque.enqueueFront(1);
        var result = deque.dequeueFront();
        Assertions.assertEquals(1, result);
    }

    @Test
    public void dequeueRearElementResultingInEmptyDeque() {
        deque.enqueueRear(1);
        var result = deque.dequeueRear();
        Assertions.assertEquals(1, result);
    }

    @Test
    public void dequeueFrontElementResultingInNonEmptyDeque() {
        deque.enqueueFront(1);
        deque.enqueueFront(2);
        var result = deque.dequeueFront();
        Assertions.assertEquals(2, result);
    }

    @Test
    public void dequeueRearElementResultingInNonEmptyDeque() {
        deque.enqueueRear(1);
        deque.enqueueRear(2);
        var result = deque.dequeueRear();
        Assertions.assertEquals(2, result);
    }

    @Test
    public void dequeueFrontOnEmptyDeque() {
        Assertions.assertThrows(RuntimeException.class, deque::dequeueFront);
    }

    @Test
    public void dequeueRearOnEmptyDeque() {
        Assertions.assertThrows(RuntimeException.class, deque::dequeueRear);
    }

    @Test
    public void getDequeElementsAsString() {
        deque.enqueueFront(2);
        deque.enqueueRear(3);
        deque.enqueueFront(1);
        var result = deque.toString();
        Assertions.assertEquals("[1 2 3]", result);
    }
}
