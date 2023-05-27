package uy.edu.um.prog2.entities.tads.stack;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.exceptions.stack.EmptyStackException;
import uy.edu.um.prog2.interfaces.stack.MyStack;
import static org.junit.jupiter.api.Assertions.*;

class MyStackImplTest {
    @Test
    void pop() {
        MyStack<String> stack = new MyStackImpl<>();
        stack.push("Hi");
        stack.push("Bye");
        try {
            stack.pop();
            String s = stack.top();
            assertEquals("Hi",s);
        }catch(Exception e){
            assertEquals(1,2);
        }

    }

    @Test
    void top() {
        MyStack<String> stack = new MyStackImpl<>();
        stack.push("Hi");
        stack.push("Bye");
        try {
            String s = stack.top();
            assertEquals("Bye",s);
        }catch(Exception e){
            assertEquals(1,2);
        }
    }

    @Test
    void push(){
        MyStack<String> stack = new MyStackImpl<>();
        stack.push("Hi");
        try {
            String s = stack.top();
            assertEquals("Hi",s);
        }catch(Exception e){
            assertEquals(1,2);
        }
    }

    @Test
    void makeEmpty() {
        MyStack<String> stack = new MyStackImpl<>();
        stack.push("value 1");
        stack.push("value 2");
        stack.push("value 3");
        stack.push("value 4");
        try {
            stack.makeEmpty();
            String s = stack.top();
            assertEquals(1,2);
        }catch(EmptyStackException e){
            assertEquals(1,1);
        }catch(Exception e){
            assertEquals(1,3);
        }
    }
}