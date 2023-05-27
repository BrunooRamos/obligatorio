package uy.edu.um.prog2.entities.tads.linkedlist;

public class Nodo  <Object extends Comparable<Object>> {
    private Object value;
    private Nodo next;
    private int contador;

    public Nodo(Object value) {
        this.value = value;
    }

    public Nodo getNext() {
        return next;
    }

    public Object getValue() {
        return value;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

}
