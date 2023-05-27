package uy.edu.um.prog2.interfaces.queue;

import uy.edu.um.prog2.exceptions.queue.EmptyQueueException;

public interface MyQueue <T> {
    public void enqueue (T element);
    public T dequeue () throws EmptyQueueException;
    public boolean isEmpty();
}
