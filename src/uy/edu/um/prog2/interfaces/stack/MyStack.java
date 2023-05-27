package uy.edu.um.prog2.interfaces.stack;

import uy.edu.um.prog2.exceptions.stack.EmptyStackException;

public interface MyStack <T> {
    public void pop() throws EmptyStackException;
    public T top() throws EmptyStackException;
    public void push(T element);
    public boolean isEmpty ();
    public void makeEmpty();
}
