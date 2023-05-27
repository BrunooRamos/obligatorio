package uy.edu.um.prog2.exceptions.stack;

public class EmptyStackException extends Exception{
    public EmptyStackException() {
    }

    public EmptyStackException(String message) {
        super(message);
    }
}