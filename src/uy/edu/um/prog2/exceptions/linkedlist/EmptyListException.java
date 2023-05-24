package uy.edu.um.prog2.exceptions.linkedlist;

public class EmptyListException extends Exception{
    public EmptyListException(String mensaje){
        super(mensaje);
    }
}