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
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("0");
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");
        ls.add("5");
        assertEquals("0",ls.get(0));
        assertEquals("1",ls.get(1));
        assertEquals("2",ls.get(2));
        assertEquals("3",ls.get(3));
        assertEquals("4",ls.get(4));
        assertEquals("5",ls.get(5));
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
//hay que implementar -->
    @Test
    void addAscending() {
    }

    @Test
    void contains() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.add("3");

        assertTrue(ls.contains("2"));
    }

    @Test
    void containsAll() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("a");
        ls.add("5");
        ls.add("6");
        MyDoublyLinkedList<String> ls2 = new DoublyLinkedList<>();
        ls2.add("3");
        ls2.add("a");
        ls2.add("5");
        MyDoublyLinkedList<String> ls3 = new DoublyLinkedList<>();
        ls3.add("3");
        ls3.add("b");
        ls3.add("5");

        assertTrue(ls.containsAll(ls2));
        assertFalse(ls.containsAll(ls3));
    }

    @Test
    void containsAllStrict() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("a");
        ls.add("5");
        ls.add("6");
        MyDoublyLinkedList<String> ls2 = new DoublyLinkedList<>();
        ls2.add("3");
        ls2.add("a");
        ls2.add("5");
        MyDoublyLinkedList<String> ls3 = new DoublyLinkedList<>();
        ls3.add("a");
        ls3.add("3");
        ls3.add("5");

        assertTrue(ls.containsAll(ls2,true));
        assertFalse(ls.containsAll(ls3,true));
    }

    @Test
    void isEmpty() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        assertTrue(ls.isEmpty());
        ls.add("1");
        ls.add("2");
        ls.add("3");
        assertFalse(ls.isEmpty());
        ls.remove(0);
        ls.remove(0);
        ls.remove(0);
        assertTrue(ls.isEmpty());
    }

    @Test
    void addFirst() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.addFirst("0");
        assertEquals("0",ls.get(0));
    }

    @Test
    void addLast() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.addLast("3");
        assertEquals("3",ls.get(2));
    }
    //hay que implementar -->
    @Test
    void iterator() {
        //creo que ya hay un test para esto pero no estoy seguro
    }

    @Test
    void indexOf() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");
        assertEquals(0,ls.indexOf("1"));
        assertEquals(1,ls.indexOf("2"));
        assertEquals(4,ls.indexOf("3"));
        assertEquals(5,ls.indexOf("4"));
    }

    @Test
    void lastIndexOf() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");
        assertEquals(2,ls.lastIndexOf("1"));
        assertEquals(3,ls.lastIndexOf("2"));
        assertEquals(4,ls.lastIndexOf("3"));
        assertEquals(5,ls.lastIndexOf("4"));
    }

    @Test
    void testEquals() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.add("1");

        MyDoublyLinkedList<String> ls2 = new DoublyLinkedList<>();
        ls2.add("1");
        ls2.add("2");
        ls2.add("1");
        assertTrue(ls.equals(ls2));

        MyDoublyLinkedList<String> ls3 = new DoublyLinkedList<>();
        ls3.add("2");
        ls3.add("1");
        ls3.add("1");
        assertFalse(ls.equals(ls3));
    }

    @Test
    void size() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.add("1");

        assertEquals(3,ls.size());

        ls.remove(0);

        assertEquals(2,ls.size());
    }

    @Test
    void clear() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("1");
        ls.add("2");
        ls.add("1");

        ls.clear();
        assertTrue(ls.isEmpty());
    }

    @Test
    void removeAll() {
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("a");
        ls.add("b");
        ls.add("c");

        MyDoublyLinkedList<String> ls2 = new DoublyLinkedList<>();
        ls2.add("a");
        ls2.add("2");

        boolean flag = ls.removeAll(ls2);

        assertEquals("b",ls.get(0));
        assertTrue(flag);

        MyDoublyLinkedList<String> ls3 = new DoublyLinkedList<>();
        ls3.add("NOT");
        ls3.add("HERE");

        flag = ls.removeAll(ls3);

        assertEquals("b",ls.get(0));
        assertFalse(flag);
    }
    @Test
    void removeValue(){
        MyDoublyLinkedList<String> ls = new DoublyLinkedList<>();
        ls.add("a");
        ls.add("b");
        ls.add("c");
        ls.add("d");
        ls.add("e");
        ls.add("f");

        boolean flag = ls.remove("c");

        assertEquals("a",ls.get(0));
        assertEquals("b",ls.get(1));
        assertEquals("d",ls.get(2));
        assertEquals("e",ls.get(3));
        assertEquals("f",ls.get(4));
        assertTrue(flag);

        flag = ls.remove("g");

        assertFalse(flag);
    }
}

