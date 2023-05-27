package uy.edu.um.prog2.entities.tads.linkedlist;

import uy.edu.um.prog2.exceptions.linkedlist.EmptyListException;
import uy.edu.um.prog2.interfaces.linkedlist.MyLinkedList;

public class MyLinkedListImp implements MyLinkedList {
    Nodo primero;
    int counter;

    public int getCounter() {
        return counter;
    }

    @Override
    public void add(Object valor){
        Nodo nuevo = new Nodo((Comparable) valor);

        if (primero == null) {
            primero = nuevo;
        } else{
            Nodo temp = primero;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(nuevo);
        }
        counter++;
    }

    public void addPosition(Object valor, int position) throws EmptyListException {
        Nodo nuevo = new Nodo((Comparable) valor);

        if (position > counter){
            throw new EmptyListException("La lista no tiene tantos elementos");
        } else {
            if (primero == null){
                primero = nuevo;
                counter++;
            } else if (position ==0){

                nuevo.setNext(primero);
                primero = nuevo;
                counter++;

            } else {

                Nodo temp = primero;
                Nodo prev = null;

                for (int i =0; i<position; i++){
                    prev = temp;
                    temp = temp.getNext();
                }


                nuevo.setNext(temp);
                prev.setNext(nuevo);
                counter++;
            }
        }

    }


    public void addFirst(Object valor){
        Nodo nodo = new Nodo((Comparable) valor);

        if(primero == null){
            primero = nodo;
        }else {
            nodo.setNext(primero);
            primero = nodo;
            counter = counter +1;
        }
    }

    @Override
    public void remove(Integer position) throws EmptyListException{
        if(primero == null){
            System.out.println("La lista esta vacía.");
            throw new EmptyListException("Lista vaica");
        }else{
            try{
                Nodo anterior = primero;
                int i = 0;
                boolean fueBorrado = false;

                if (position == 0){
                    primero = primero.getNext();
                }else{
                    while(!fueBorrado){
                        if(position-1 == i){
                            //El anterior al que quiero borrar
                            fueBorrado = true;
                        }
                        else {
                            anterior = anterior.getNext();
                            i++;
                        }
                    }
                    //Este seria el que quiero borrar
                    Nodo siguiente = anterior.getNext();
                    //Conecto al anterior con el siguiente del borrado, ignoro al que quiero borrar.
                    anterior.setNext(siguiente.getNext());
                    counter--;
                }
            }catch(Exception e){
                throw new EmptyListException("Lista vacia");
            }
        }
    }


    @Override
    public Object get(Integer position) {
        Object valueToReturn = null;
        int tempPosition = 0;
        Nodo temp = this.primero;

        // Se busca el nodo que corresponde con la posicion
        while (temp != null && tempPosition != position) {

            temp = temp.getNext();
            tempPosition++;

        }

        // si se encontro la posicion se retorna el valor
        // en caso que se haya llegado al final y no se llego a la posicion se retorna null
        if (tempPosition == position) {


            valueToReturn = temp.getValue();

        }

        return valueToReturn;
    }

    //Esta funcion me dice si el elemento esta en la lista (retorna true o false)
    public boolean isInList(Object value){
        boolean isThere = false;
        Nodo temp = primero;

        for(int i = 0; i<counter; i++){
            if(temp.getValue().equals(value)){
                isThere = true;
            }
            temp = temp.getNext();
        }

        return isThere;
    }

    public void imprimir(){
        if (primero != null) {
            Nodo temp = primero;

            while(temp != null){
                System.out.print(temp.getValue()+ "|");
                temp = temp.getNext();
            }
        }
    }

    public void visualizar(MyLinkedListImp listaEnlazadaNumeros){
        Nodo tempNumeros = listaEnlazadaNumeros.primero;
        int contadorPasos = 0;

        boolean tieneElementos = true;
        int posicion = 0;

        while (tieneElementos){
            posicion = Integer.parseInt(tempNumeros.getValue().toString());
            if (posicion<counter){
                System.out.println(get(posicion-1));
            }
            contadorPasos++;
            tempNumeros = tempNumeros.getNext();

            if (listaEnlazadaNumeros.counter==contadorPasos || counter ==contadorPasos){
                tieneElementos = false;
            }
        }
    }
}
