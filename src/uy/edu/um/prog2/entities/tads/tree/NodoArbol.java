package uy.edu.um.prog2.entities.tads.tree;

public class NodoArbol<K, T> {
    K key;
    K parent;
    T data;
    NodoArbol nodoIzquierdo;
    NodoArbol nodoDerecho;

    public NodoArbol(K key, T data, K parent) {
        this.key = key;
        this.data = data;
        this.parent = parent;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public K getParent() {
        return parent;
    }

    public void setParent(K parent) {
        this.parent = parent;
    }
}
