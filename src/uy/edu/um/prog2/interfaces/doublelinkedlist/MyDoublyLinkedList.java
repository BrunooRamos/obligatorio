package uy.edu.um.prog2.interfaces.doublelinkedlist;

import java.util.Iterator;

public interface MyDoublyLinkedList  <T> extends Iterable<T>{

    //agrega un elemento al final de la lista
    public void add(T value);
    //agrega un elemento en un índice de la lista desplazando el resto de la lista hacia el final de la lista
    public void add(int index, T value);
    //agrega un elemento al principio de la lista desplazando el resto de la lista hacia el final de la lista
    public void addFirst(T value);
    //agrega un elemento al final de la lista
    public void addLast(T value);
    //quita un elemento en un índice de la lista desplazando el resto de la lista hacia el principio de la lista
    public T remove(int pos);
    //quita de la lista la primera instancia del elemento proporcionado, desplazando el resto de la lista hacia el principio de la lista
    public boolean remove(T value);
    // elimina todos los elementos de la lista que coinciden con la lista proporcionada
    public boolean removeAll(MyDoublyLinkedList<T> ls);
    //devuelve true si la lista esta vacía
    public boolean isEmpty();
    //devuelve el elemento en el índice proporcionado
    public T get(int pos);
// !-->    //falta implementar
    public void addAscending(T value);
    //retorna true si el elemento proporcionado está en la lista
    public boolean contains(T value);
    //retorna true si los elementos proporcionados están en la lista (orden no importa)
    public boolean containsAll(MyDoublyLinkedList<T> ls);
    //retorna true si los elementos proporcionados están en la lista en el orden dado
    public boolean containsAll(MyDoublyLinkedList<T> ls, boolean strict);
    //magia que hace que la lista sea iterable
    public Iterator<T> iterator();
    //devuelve el primer índice de un valor en la lista
    public int indexOf(T item);
    //devuelve el último índice de un valor en la lista
    public int lastIndexOf(T item);
    //devuelve el tamaño de la lista
    public int size();
//! --> falta implementar    //devuelve true si la lista proporcionada es tiene los mismos elementos en el mismo orden que la lista
    public boolean equals(Object o);
    //elimina todos los elemento de la lista
    public void clear();
}
//ver:
// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html#containsAll(java.util.Collection)
//para documentación más detallada
