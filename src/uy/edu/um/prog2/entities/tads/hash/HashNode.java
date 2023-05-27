package uy.edu.um.prog2.entities.tads.hash;

public class HashNode<K,T> {
    K key;
    T data;
    boolean borrado;

    public HashNode(K key, T data) {
        this.key = key;
        this.data = data;
        this.borrado = false;
    }

    public K getKey() {return key;}

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setIsBorrado(boolean estaBorrado) {
        this.borrado = estaBorrado;
    }
}
