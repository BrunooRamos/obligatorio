package uy.edu.um.prog2.interfaces.treeBST;

import uy.edu.um.prog2.exceptions.treeBST.ErrorControlado;

public interface MyBinarySearchTree<K extends Comparable<K>, T> {
    T find(K key);
    void insert(K key, T data);
    void delete(Object key) throws ErrorControlado;
}