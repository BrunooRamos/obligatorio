package uy.edu.um.prog2.entities.tads.linkedlist;

public class Node <Tipo> {
    private Tipo value;
    private Node next;

    public Node(Tipo value){
        this.value = value;
        this.next  = null;
    }

    public Tipo getValue() {
        return value;
    }

    public void setValue(Tipo value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
