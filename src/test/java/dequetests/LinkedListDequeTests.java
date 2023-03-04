package dequetests;

import deques.LinkedListDeque;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LinkedListDequeTests {
    private final LinkedListDeque<Integer> deque = new LinkedListDeque<>();

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
    @Test

    public void removeAnElement() {
        deque.enqueueFront(1);
        deque.remove(1);
        var result = deque.size();
        Assertions.assertEquals(0, result);
    }
    @Test

    public void removeMultipleElements() {
        for(int i = 0; i < 5; i++) {
            deque.enqueueFront(i);
        }
        deque.remove(5);
        var result = deque.size();
        Assertions.assertEquals(0, result);
    }
    @Test

    public void swapTwoFrontElements() {
        for(int i = 0; i < 5; i++) {
            deque.enqueueFront(i + 1);
        }
        deque.swapStart();
        var result = deque.dequeueFront();
        Assertions.assertEquals(4, result);
    }
    
    @Test
    public void swapTwoRearElements() {
        for(int i = 0; i < 5; i++) {
            deque.enqueueFront(i + 1);
        }
        deque.swapEnds();
        var result = deque.dequeueRear();
        Assertions.assertEquals(2, result);
    }
}
