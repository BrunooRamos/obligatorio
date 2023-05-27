package uy.edu.um.prog2.exceptions.queue;

public class EmptyQueueException extends Exception{
    public EmptyQueueException() {
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}
