package uy.edu.um.prog2.interfaces.linkedlist;

import uy.edu.um.prog2.exceptions.linkedlist.EmptyListException;

public interface MyLinkedList {
    void add(Object value);
    void remove(Integer position) throws EmptyListException;
    Object get(Integer position);
}
