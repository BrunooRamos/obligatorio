package uy.edu.um.prog2.entities.tads.treeBST;

public class NodeBST <K extends Comparable<K>, T> {

    K key;
    T data;
    NodeBST <K, T> nodoIzquierdo;
    NodeBST <K, T> nodoDerecho;

    public NodeBST(K key, T data) {
        this.key = key;
        this.data = data;
    }

    public int compareTo(NodeBST<K,T> nodo){
        return key.compareTo(nodo.key);
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
}