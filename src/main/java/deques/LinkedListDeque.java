package deques;

import exceptions.EmptyDequeDequeueException;
import nodes.Node;

public class LinkedListDeque<T> implements DequeInterface<T> {
    private Node<T> front = null;
    private Node<T> rear = null;
    private int nodeCount = 0;

    /**
     * enqueueFront Inserts a new node at the front of the Deque.
     * @param data The data for the new node to hold.
     */
    public void enqueueFront(T data) {
        Node<T> insert = new Node<>(data);
        if(nodeCount == 0) {
            front = rear = insert;
        } else {
            insert.setNext(front);
            front = insert;
        }
        nodeCount++;
    }

    /**
     * enqueueRear Inserts a new node at the rear of the Deque.
     * @param data The data for the new node to hold.
     */
    public void enqueueRear(T data) {
        Node<T> insert = new Node<>(data);
        if(nodeCount == 0) {
            front = rear = insert;
        } else {
            rear.setNext(insert);
            rear = insert;
        }
        nodeCount++;
    }

    /**
     * dequeueFront Removes a node from the front of the Deque.
     * @return The data held by the removed node.
     */
    public T dequeueFront() {
        if(isEmpty()) {
            throw new EmptyDequeDequeueException("dequeue attempted on an empty queue.");
        }
        T removedNode = front.getData();
        if(nodeCount == 1) {
            front = rear = null;
        } else {
            front = front.getNext();
        }
        nodeCount--;
        return removedNode;
    }

    /**
     * dequeueRear Removes a node from the rear of the Deque.
     * @return The data held by the removed node.
     */
    public T dequeueRear() {
        if(isEmpty()) {
            throw new EmptyDequeDequeueException("dequeue attempted on an empty queue.");
        }
        T removedNode = rear.getData();
        if(nodeCount == 1) {
            front = rear = null;
            nodeCount--;
        } else {
            Node<T> parser = front;
            while(parser != null) {
                if(parser.getNext().getNext() == null) {
                    parser.setNext(null);
                    nodeCount--;
                }
                parser = parser.getNext();
            }
        }
        return removedNode;
    }

    /**
     * isEmpty Checks if the Deque is empty..
     * @return True if the Deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return nodeCount == 0;
    }

    /**
     * isFull Checks if the Deque is full.
     * @return False, as a Deque implemented with a linked list cannot be full.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * size Returns the size of the Deque.
     * @return The amount of nodes in the Deque.
     */
    public int size() {
        return nodeCount;
    }

    /**
     * remove Removes a set amount of nodes from the front of the Deque.
     * @param count The amount of nodes to be removed.
     */
    public void remove(int count) {
        if(count > nodeCount) {
            throw new EmptyDequeDequeueException("Not enough elements for removal.");
        }
        for(int i = 0; i < count; i++) {
            front = front.getNext();
            nodeCount--;
            if(nodeCount == 0) {
                front = rear = null;
            }
        }
    }

    /**
     * swapStart Swaps the first two nodes at the front of the Deque.
     * @return True if the swap was successful, false otherwise.
     */
    public boolean swapStart() {
        if(nodeCount < 2) {
            return false;
        } else if(nodeCount == 2) {
            rear.setNext(front);
            front.setNext(null);
            front = rear;
            rear = front.getNext();
            System.out.println();
        } else {
            Node<T> temp1 = front.getNext();
            Node<T> temp2 = temp1.getNext();
            temp1.setNext(front);
            front.setNext(temp2);
            front = temp1;
        }
        return true;
    }

    /**
     * swapEnds Swaps the last two nodes at the rear of the Deque.
     * @return True if the swap was successful, false otherwise.
     */
    public boolean swapEnds() {
        if(nodeCount < 2) {
            return false;
        }
        if(nodeCount == 2) {
            front.setNext(null);
            rear.setNext(front);
            front = rear;
            rear = front.getNext();
            return true;
        }
        Node<T> parser = front;
        while(parser.getNext() != null) {
            if(parser.getNext().getNext() == rear) {
                Node<T> temp = parser.getNext();
                parser.setNext(rear);
                rear.setNext(temp);
                temp.setNext(null);
                rear = rear.getNext();
                return true;
            }
            parser = parser.getNext();
        }
        return false;
    }

    /**
     * toString Outputs information about the Queue.
     * @return A string containing information about the Queue.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> parser = front;
        while(parser != rear) {
            sb.append(parser.getData()).append(" ");
            parser = parser.getNext();
        }
        return sb.append(rear.getData()).append("]").toString();
    }
}
