package uy.edu.um.prog2.entities.tads.doublelinkedlist;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.interfaces.doublelinkedlist.MyDoublyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @org.junit.jupiter.api.Test
    void add() {
        var ls = new DoublyLinkedList();
        ls.add("HI");
        assertEquals("HI", ls.get(0));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        var ls = new DoublyLinkedList();
        ls.add("HI");
        ls.add("HI");
        ls.add(1);
        ls.remove(1);
        assertEquals(1,ls.get(1));
        assertThrows(IndexOutOfBoundsException.class,() -> {ls.get(2);});
    }

    @org.junit.jupiter.api.Test
    void removeFirst() {
        var ls = new DoublyLinkedList();
        ls.add("HI");
        ls.add(1);
        ls.remove(0);
        assertEquals(1,ls.get(0));
        assertThrows(IndexOutOfBoundsException.class,() -> {ls.get(1);});
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
        var ls = new DoublyLinkedList();
        ls.add("HI");
        ls.add(1);
        ls.remove(1);
        assertEquals("HI",ls.get(0));
        assertThrows(IndexOutOfBoundsException.class,() -> {ls.get(1);});
    }

    @org.junit.jupiter.api.Test
    void get() {
        var ls = new DoublyLinkedList();
        ls.add("HI");
        ls.add(1);
        assertEquals("HI",ls.get(0));
        assertEquals(1,ls.get(1));
    }

    @org.junit.jupiter.api.Test
    void getWhilstEmpty() {
        var ls = new DoublyLinkedList();
        assertThrows(IndexOutOfBoundsException.class,() -> {ls.get(0);});
    }

    @Test
    void canIterate() {
        var ls = new DoublyLinkedList();
        ls.add("HI");
        ls.add(1);
        ls.add(2);
        ls.add(3);
        int i = 0;
        for(Object k : ls){
            System.out.println(k);
            switch (i){
                case 0 :
                    assertEquals("HI",k);
                    break;
                case 1 :
                    assertEquals(1,k);
                    break;
                case 2 :
                    assertEquals(2,k);
                    break;
                case 3 :
                    assertEquals(3,k);
                    break;
            }
            i++;
        }
        assertEquals("HI",ls.get(0));
    }

    @Test
    void addAtIndexCenter() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("Hi");
        ls.add("Bye");
        ls.add("!");

        ls.add(1,",wait,");
        assertEquals(",wait,",ls.get(1));
    }
    @Test
    void addAtIndex0() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("Hi");
        ls.add("Bye");
        ls.add("!");

        ls.add(0,"str:");
        assertEquals("str:",ls.get(0));

    }
    @Test
    void addAtIndexEnd() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("Hi");
        ls.add("Bye");
        ls.add("!");

        ls.add(3,":end");
        assertEquals(":end",ls.get(3));
    }

    @Test
    void addAscending() {
    }

    @Test
    void contains() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.add("3");

        assertEquals(true,ls.contains("2"));
    }

    @Test
    void containsAll() {

    }

    @Test
    void testContainsAll() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void addFirst() {
    }

    @Test
    void addLast() {
    }

    @Test
    void iterator() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }

    @Test
    void removeAll() {
    }
}