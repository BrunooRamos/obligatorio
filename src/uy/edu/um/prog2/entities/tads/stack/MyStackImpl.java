package uy.edu.um.prog2.entities.tads.stack;

import uy.edu.um.prog2.entities.tads.doublelinkedlist.DoublyLinkedList;
import uy.edu.um.prog2.exceptions.stack.EmptyStackException;
import uy.edu.um.prog2.interfaces.stack.MyStack;

public class MyStackImpl<T> extends DoublyLinkedList<T> implements MyStack<T> {
    public MyStackImpl() {
        super();
    }
    @Override
    public void pop() throws EmptyStackException {
        if (this.isEmpty()){ throw new EmptyStackException();}
        this.remove(this.size() - 1);
    }
    @Override
    public T top() throws EmptyStackException {
        if (this.isEmpty()){ throw new EmptyStackException();}
        return this.get(this.size() - 1);
    }
    @Override
    public void push(T element) {
        this.add(element);
    }
    @Override
    public void makeEmpty() {
        this.clear();
    }
}
