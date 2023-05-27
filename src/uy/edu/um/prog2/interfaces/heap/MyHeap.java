package uy.edu.um.prog2.interfaces.heap;

public interface MyHeap<T extends Comparable<T>> {
    T deleteMAX();
    T get();
    void insertMAX(T element);
    int size();
}