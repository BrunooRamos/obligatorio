package uy.edu.um.prog2.entities.tads.doublecircularlinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DoubleCircularLinkedListTest {
    @Test
    void add() {
        DoubleCiruclarLinkedList dl = new DoubleCiruclarLinkedList();
        dl.add("Hello");
        dl.add("World");
        dl.add(1);


        assertEquals("Hello",dl.get(0));
        assertEquals("World",dl.get(1));
        assertEquals(1,dl.get(2));

        assertEquals("Hello",dl.get(3));
        assertEquals("World",dl.get(4));
        assertEquals(1,dl.get(5));
    }

    @Test
    void remove() {
        DoubleCiruclarLinkedList dl = new DoubleCiruclarLinkedList();
        dl.add("Hello");
        dl.add("World");
        dl.add(1); // hello - world - 1

        dl.remove(1); // hello - 1

        assertEquals("Hello",dl.get(0));
        assertEquals(1,dl.get(1));
        assertEquals("Hello",dl.get(2));

        dl.add("!"); // hello - 1 - !

        dl.remove(5); // hello - 1

        assertEquals(1,dl.get(3));
        assertEquals("Hello",dl.get(4));
        assertEquals(1,dl.get(5));
    }


    @Test
    void get() {
    }
}