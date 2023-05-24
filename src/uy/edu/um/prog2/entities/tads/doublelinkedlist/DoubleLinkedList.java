package uy.edu.um.prog2.entities.tads.doublelinkedlist;

import uy.edu.um.prog2.interfaces.doublelinkedlist.MyDoubleLinkedList;

import java.util.Iterator;
import java.util.Objects;

public class DoubleLinkedList <T> implements MyDoubleLinkedList<T>,Iterable<T>{
    private DoubleNode<T> first   = null;
    private DoubleNode<T> last    = null;
    private int length            = 0;

    @Override
    public void add(T value) {
        DoubleNode<T> newNode = new DoubleNode<T>(value);
        if (this.first == null) {
            this.first = newNode;
            this.length++;
            return;
        }

        DoubleNode<T> temp = this.first;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        newNode.setPrevious(temp);
        temp.setNext(newNode);
        this.length++;
    }
    public void add(int index,T value) throws IndexOutOfBoundsException{
        DoubleNode<T> temp = new DoubleNode<>(value);
        if (index < 0){
            throw new IndexOutOfBoundsException("negative index given");
        }
        if (index > this.length){
            throw new IndexOutOfBoundsException("index given exceeds list length - 1");
        }

        if (index==0){
            if (this.isEmpty()){
                this.add(value);
                return;
            }
            temp.setNext(this.first);
            this.first.setPrevious(temp);
            this.first = temp;
        }

        DoubleNode<T> nodeAtIndexPosition         = this.getNode(index);
        DoubleNode<T> nodeAtIndexPositionMinusOne = this.getNode(index - 1);

        nodeAtIndexPosition.setPrevious(temp);
        temp.setNext(nodeAtIndexPosition);

        nodeAtIndexPositionMinusOne.setNext(temp);
        temp.setPrevious(nodeAtIndexPositionMinusOne);
    }


    @Override
    public T remove(int pos) throws IndexOutOfBoundsException{

        if (this.first == null) {
            throw new IndexOutOfBoundsException();
        }

        DoubleNode<T> deadMan  = this.getNode(pos);

        DoubleNode<T> next     = null;

        if (deadMan.getPrevious() != null) {
            DoubleNode<T> previous   = deadMan.getPrevious();

            if (deadMan.getNext() != null){
                next       = deadMan.getNext();
                next.setPrevious(previous);
            }
            previous.setNext(next);
        }else if (deadMan.getNext() != null){
            next       = deadMan.getNext();
            next.setPrevious(null);
            this.first = next;
        }else{
            this.first = null;
        }
        this.length--;

        return deadMan.getValue();

    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException{
        return this.getNode(pos).getValue();
    }

    public DoubleNode<T> getNode(int pos) throws IndexOutOfBoundsException{

        if (this.first == null) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }

        if (pos < 0) {
            throw new IndexOutOfBoundsException("negative index given");
        }

        if (pos > this.length - 1){
            throw new IndexOutOfBoundsException("index given exceeds list length - 1");
        }

        DoubleNode<T> temp = this.first;
        if(pos <= Math.floor(this.length/2)){
            for (int i = 0;i != pos;i++) {
                if (temp.getNext() == null) {
                    throw new Error("internal list node pointer missing");
                }
                temp = temp.getNext();
            }
        }else{
            for (int i = 0;i != pos;i++) {
                if (temp.getNext() == null) {
                    throw new Error("internal list node pointer missing");
                }
                temp = temp.getPrevious();
            }
        }

        return temp;
    }

    public void addAscending(T value){
        //no entendi bien la consigna
    }

    @Override
    public boolean contains(T value) {
        for(T item : this){
            if (item == value){
                return true;
            }
        }


        return false;
    }

    @Override
    public boolean containsAll(MyDoubleLinkedList<T> ls) {
        return this.containsAll(ls,false);
    }
    @Override
    public boolean containsAll(MyDoubleLinkedList<T> ls,boolean strict) {
        if(ls.size() > this.size()){
            return false;
        }

        if(strict) {
            int compIndex = indexOf(ls.get(0));

            if(ls.size() < this.length - compIndex){
                return false;
            }

            while (compIndex < ls.size()){
                if (ls.get(compIndex) != this.get(compIndex)){
                    return false;
                }
                compIndex++;
            }

        }else{
            boolean flag;
            for (T lsItem : ls) {
                flag = false;
                for (T item : this) {
                    if (item == lsItem) {
                        flag = true;
                    }
                }
                if (!flag) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isEmpty(){
        return this.first==null;
    }

    public void addFirst(T value){
        this.add(0,value);
    }

    public void addLast(T value){
        this.add(this.length - 1,value);
    }


    //permite que este TAD sea iterable
    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator();
    }

    @Override
    public int indexOf(T item) {
        int i = 0;
        for(T k:this){
            if (k == item){
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        int i = 0;
        int lastPos = -1;
        for(T k:this){
            if (k == item){
                lastPos = i;
            }
            i++;
        }
        return lastPos;
    }

    private class DoublyLinkedListIterator implements Iterator<T> {
        private DoubleNode<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() throws IndexOutOfBoundsException{
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("err");
            }
            T value = current.getValue();
            current = current.getNext();
            return value;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleLinkedList<?> that = (DoubleLinkedList<?>) o;
        return length == that.length && Objects.equals(first, that.first) && Objects.equals(last, that.last) && this.containsAll((MyDoubleLinkedList<T>) o,true);
    }

    public int size() {
        return length;
    }

    public void clear(){
        this.first  = null;
        this.last   = null;
        this.length = 0;
    }

    @Override
    public boolean removeAll(MyDoubleLinkedList<T> ls) {
        return false;
    }
}
