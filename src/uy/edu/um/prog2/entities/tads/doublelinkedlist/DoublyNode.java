package uy.edu.um.prog2.entities.tads.doublelinkedlist;

public class DoublyNode<T>{
    private T value;
    private DoublyNode<T> next;

    private DoublyNode<T> previous;

    private int priority = 0;
    public DoublyNode(T value){
        this.value      = value;
        this.next       = null;
        this.previous   = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoublyNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }

    public DoublyNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyNode<T> previous) {
        this.previous = previous;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
