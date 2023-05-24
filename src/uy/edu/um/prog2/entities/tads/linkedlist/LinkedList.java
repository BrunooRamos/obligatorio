package uy.edu.um.prog2.entities.tads.linkedlist;

import uy.edu.um.prog2.exceptions.linkedlist.EmptyListException;
import uy.edu.um.prog2.interfaces.linkedlist.MyLinkedList;

public class LinkedList <Tipo> implements MyLinkedList<Tipo> {
    private Node first;
    private int length = 0;

    //Metodos propias de la interfaz, tienen que estar de manera obligatoria.

    @Override
    public void add(Tipo value) {
        if (this.first == null) {
            this.first = new Node<Tipo>(value);
        } else {
            Node<Tipo> temp = this.first;
            // while ((temp = temp.getNext()) != null); tendria probs en ejecucion
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            Node<Tipo> newNode = new Node<>(value);
            temp.setNext(newNode);
        }
        this.length++;
    }

    //El remove no esta borrando el ultimo elemento, por algun motivo se lo saltea.
    @Override
    public void remove(int pos) {
        if (this.first == null) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }
        if (pos>= length){
            throw new IndexOutOfBoundsException("LinkedList has not enough elements");
        }
        if (pos != 0) {
            Node<Tipo> tempNext;

            try {
                tempNext = this.getNode(pos + 1);
            }catch (IndexOutOfBoundsException e){
                tempNext = null;
            }

            Node<Tipo> tempPrevious = this.getNode(pos-1);

            tempPrevious.setNext(tempNext);

        } else {
            this.first = this.getNode(1);
        }
        this.length--;
    }

    @Override
    public Tipo get(int pos) throws IndexOutOfBoundsException{
        Node <Tipo> temp =  this.getNode(pos);
        return temp.getValue();
    }

    //Metodos complementarios/auxiliares

    public int getLength() {
        return length;
    }

    private Node <Tipo> getNode(int pos) throws IndexOutOfBoundsException{
        if (this.first == null) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }
        Node <Tipo> temp = this.first;
        int counter = 0;
        while (temp.getNext() != null && counter != pos) {
            if (temp.getNext() == null && counter != pos) {
                throw new IndexOutOfBoundsException();
            }
            counter ++;
            temp = temp.getNext();
        }
        return temp;
    }

    public boolean has(Tipo value) throws IndexOutOfBoundsException{
        if (this.first == null) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }

        Node<Tipo> temp = this.first;

        do {
            if (temp.getValue() == value) {
                return true;
            }
            temp = temp.getNext();
        } while (temp != null);

        return false;
    }

    public void addFirst(Tipo value) {
        if (this.first == null) {
            this.add(value);
            return;
        }

        Node<Tipo> temp = new Node<>(value);
        temp.setNext(this.first);
        this.first = temp;
        this.length++;
    }

    public void addLast(Tipo value) {
//        if (this.first == null) {
//            this.add(value);
//            return;
//        }
//
//        Node<Tipo> temp = new Node<>(value);
//        this.getNode(this.length - 2).setNext(temp);
//        this.length++;

        //Puesto por BRUNO
        this.add(value);
    }

    public boolean checkLength(){
        if (this.first == null){
            return this.getLength() == 0;
        }

        Node temp = this.first;
        int counter = 1;

        while (temp.getNext() != null) {
            //Puesto por BRUNO
            temp = temp.getNext();
            counter ++;
        }

        return counter == this.getLength();
    }

    //Agregue esta para imprimir la lista.
    public void imprimir(){
        if (first != null) {
            Node temp = first;

            while(temp != null){
                System.out.print(temp.getValue()+ "|");
                temp = temp.getNext();
            }
        }
    }

    public void addPosition(Object valor, int position) throws EmptyListException {
        Node nuevo = new Node(valor);

        if (position > length){
            throw new EmptyListException("La lista no tiene tantos elementos");
        } else {
            if (first == null){
                first = nuevo;
                length++;
            } else if (position ==0){

                nuevo.setNext(first);
                first= nuevo;
                length++;

            } else {

                Node temp = first;
                Node prev = null;

                for (int i =0; i<position; i++){
                    prev = temp;
                    temp = temp.getNext();
                }


                nuevo.setNext(temp);
                prev.setNext(nuevo);
                length++;
            }
        }

    }



}

