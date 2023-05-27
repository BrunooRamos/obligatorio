package uy.edu.um.prog2.interfaces.doublelinkedlist;

import java.util.Iterator;

public interface MyDoublyLinkedList  <T> extends Iterable<T>{

    public void add(T value);
    public void add(int index, T value);
    public void addFirst(T value);
    public void addLast(T value);
    public T remove(int pos);
    public boolean isEmpty();
    public T get(int pos);
    public void addAscending(T value);
    public boolean contains(T value);
    public boolean containsAll(MyDoublyLinkedList<T> ls);
    public boolean containsAll(MyDoublyLinkedList<T> ls, boolean strict);
    public Iterator<T> iterator();
    public int indexOf(T item);
    public int lastIndexOf(T item);
    public int size();
    public boolean equals(Object o);
    public void clear();
    public boolean removeAll(MyDoublyLinkedList<T> ls);
}
