package uy.edu.um.prog2.interfaces.tree;

import uy.edu.um.prog2.entities.tads.linkedlist.MyLinkedListImp;
import uy.edu.um.prog2.exceptions.linkedlist.EmptyListException;
import uy.edu.um.prog2.exceptions.queue.EmptyQueueException;
import uy.edu.um.prog2.exceptions.stack.EmptyStackException;
import uy.edu.um.prog2.exceptions.treeBST.ErrorControlado;

public interface MyTree<K, T> {

    T find(K key) throws ErrorControlado;

    void insert(K key, T data, K parentKey) throws ErrorControlado;

    void delete(K key) throws EmptyListException, ErrorControlado;

    Integer size() throws ErrorControlado;
    Integer countLeaf() throws ErrorControlado;
    Integer countCompleteElements() throws ErrorControlado;

    MyLinkedListImp inOrder();
    MyLinkedListImp preOrder();
    MyLinkedListImp postOrder();
}