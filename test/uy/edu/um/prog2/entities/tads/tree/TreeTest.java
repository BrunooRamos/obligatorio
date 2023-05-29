package uy.edu.um.prog2.entities.tads.tree;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.exceptions.linkedlist.EmptyListException;
import uy.edu.um.prog2.exceptions.treeBST.ErrorControlado;
import uy.edu.um.prog2.interfaces.tree.MyTree;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void findAndInsert() throws ErrorControlado {
        MyTree<Integer,String> tree = new Tree();
        tree.insert(0,"I'm a root (0)",null);
        tree.insert(1,"I'm a leaf (0)",0);
        tree.insert(2,"I'm a root (1)",0);
        tree.insert(3,"I'm a leaf (1)",2);
        tree.insert(4,"I'm a leaf (2)",2);

        assertEquals("I'm a root (0)",tree.find(0));
        assertEquals("I'm a leaf (0)",tree.find(1));
        assertEquals("I'm a root (1)",tree.find(2));
        assertEquals("I'm a leaf (1)",tree.find(3));
        assertEquals("I'm a leaf (2)",tree.find(4));
    }

    @Test
    void delete() throws ErrorControlado, EmptyListException {
        MyTree<Integer,String> tree = new Tree();
        tree.insert(0,"I'm a root (0)",null);
        tree.insert(1,"I'm a leaf (0)",0);
        tree.insert(2,"I'm a root (1)",0);
        tree.insert(3,"I'm a leaf (1)",2);
        tree.insert(4,"I'm a leaf (2)",2);

        tree.delete(2);

        assertEquals("I'm a root (0)",tree.find(0));
        assertEquals("I'm a leaf (0)",tree.find(1));
        assertNull(tree.find(2));

    }

    @Test
    void size() {
    }

    @Test
    void countCompleteElements() {
    }

    @Test
    void inOrder() {
    }

    @Test
    void preOrder() {
    }

    @Test
    void postOrder() {
    }
}