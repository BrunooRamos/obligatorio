package uy.edu.um.prog2.entities.tads.queue;

import uy.edu.um.prog2.entities.tads.doublelinkedlist.DoublyLinkedList;
import uy.edu.um.prog2.exceptions.queue.EmptyQueueException;
import uy.edu.um.prog2.interfaces.queue.MyQueue;

public class MyQueueImp <T> extends DoublyLinkedList<T> implements MyQueue<T> {
    public MyQueueImp() {
        super();
    }

    @Override
    public void enqueue(T element) {
        this.add(element);
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (this.isEmpty()) {throw new EmptyQueueException();}

        T temp = this.get(0);
        this.remove(0);
        return temp;
    }

    //REVISAR
    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }
}
