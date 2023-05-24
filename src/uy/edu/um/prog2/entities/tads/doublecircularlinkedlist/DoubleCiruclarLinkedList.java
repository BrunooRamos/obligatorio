package uy.edu.um.prog2.entities.tads.doublecircularlinkedlist;

import uy.edu.um.prog2.entities.tads.doublelinkedlist.DoubleLinkedList;
import uy.edu.um.prog2.interfaces.linkedlist.MyLinkedList;

public class DoubleCiruclarLinkedList implements MyLinkedList {
    DoubleLinkedList dl  = new DoubleLinkedList();
    int lastElementIndex = 0;


    @Override
    public void add(Object value) {
        if (dl.isEmpty()) {
            dl.add(value);
        }else{
            dl.add(value);
            this.lastElementIndex ++;
        }
    }

    @Override
    public void remove(int pos) throws IndexOutOfBoundsException{
        if (this.dl.isEmpty()){
            throw new IndexOutOfBoundsException("lista esta vacia");
        }

        dl.remove(pos % (this.lastElementIndex+1));

        this.lastElementIndex --;
    }

    @Override
    public Object get(int pos) {
        if(pos > this.lastElementIndex){
//  Alternativa con formula k = y - x(y/x) donde k es indice real, y es el indice virtual:
//            int x = this.lastElementIndex +1;
//            return dl.get((pos - x*(pos/x)));

            return dl.get(pos % (this.lastElementIndex+1));
        }else{
            return dl.get(pos);
        }
    }
}


