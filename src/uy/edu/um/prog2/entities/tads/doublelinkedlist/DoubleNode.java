package uy.edu.um.prog2.entities.tads.doublelinkedlist;

public class DoubleNode<T> {
    private T value;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;

    public DoubleNode(T value){
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

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
}
