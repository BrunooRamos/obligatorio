package uy.edu.um.prog2.entities.tads.doublelinkedlist;

import uy.edu.um.prog2.interfaces.doublelinkedlist.MyDoublyLinkedList;

import java.util.Iterator;
import java.util.Objects;

public class DoublyLinkedList <T> implements MyDoublyLinkedList<T>,Iterable<T>{
    private DoublyNode<T> first   = null;
    private DoublyNode<T> last    = null;
    protected int length      = 0;

    @Override
    public void add(T value) {
        DoublyNode<T> newNode = new DoublyNode<T>(value);
        if (this.first == null) {
            this.first = newNode;
            this.length++;
            return;
        }

        DoublyNode<T> temp = this.first;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        newNode.setPrevious(temp);
        temp.setNext(newNode);
        this.last = newNode;
        this.length++;
    }
    @Override
    public void add(int index,T value) throws IndexOutOfBoundsException{
        DoublyNode<T> temp = new DoublyNode<>(value);
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
            return;
        }

        if (index == this.length){
            this.add(value);
            return;
        }

        DoublyNode<T> nodeAtIndexPosition         = this.getNode(index);
        DoublyNode<T> nodeAtIndexPositionMinusOne = this.getNode(index - 1);

        nodeAtIndexPosition.setPrevious(temp);
        temp.setNext(nodeAtIndexPosition);

        nodeAtIndexPositionMinusOne.setNext(temp);
        temp.setPrevious(nodeAtIndexPositionMinusOne);
        this.length++;
    }
    @Override
    public T remove(int pos) throws IndexOutOfBoundsException{

        if (this.first == null) {
            throw new IndexOutOfBoundsException();
        }

        DoublyNode<T> deadMan  = this.getNode(pos);

        DoublyNode<T> next     = null;

        if (deadMan.getPrevious() != null) {
            DoublyNode<T> previous   = deadMan.getPrevious();

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
    public boolean remove(T value){
        int indexOfValue = this.indexOf(value);
        if (indexOfValue == -1){
            return false;
        }

        this.remove(indexOfValue);
        return true;
    }
    @Override
    public T get(int pos) throws IndexOutOfBoundsException{
        return this.getNode(pos).getValue();
    }
    protected DoublyNode<T> getNode(int pos) throws IndexOutOfBoundsException{

        if (this.first == null) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }

        if (pos < 0) {
            throw new IndexOutOfBoundsException("negative index given");
        }

        if (pos > this.length - 1){
            throw new IndexOutOfBoundsException("index given exceeds list length - 1");
        }


        DoublyNode<T> temp;
        if(pos <= Math.floor(this.length/2)){
            temp = this.first;
            for (int i = 0;i != pos;i++) {
                if (temp.getNext() == null) {
                    throw new Error("internal list node pointer missing");
                }
                temp = temp.getNext();
            }
        }else{
            temp = this.last;
            for (int i = this.length -1;i != pos;i--) {
                if (temp.getPrevious() == null) {
                    throw new Error("internal list node pointer missing");
                }
                temp = temp.getPrevious();
            }
        }

        return temp;
    }
    @Override
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
    public boolean containsAll(MyDoublyLinkedList<T> ls) {
        return this.containsAll(ls,false);
    }
    @Override
    public boolean containsAll(MyDoublyLinkedList<T> ls,boolean strict) {
        if(ls.size() > this.size()){
            return false;
        }

        if(strict) {
            int compIndex = indexOf(ls.get(0));

            if(ls.size() > this.length - compIndex){
                return false;
            }

            int i = 0;
            while (compIndex < this.length -1){
                if (ls.get(i) != this.get(compIndex)){
                    return false;
                }
                compIndex++;
                i++;
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
    @Override
    public boolean isEmpty(){
        return this.first==null;
    }
    @Override
    public void addFirst(T value){
        this.add(0,value);
    }
    @Override
    public void addLast(T value){
        this.add(value);
    }

    //permite que este TAD sea iterable
    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator();
    }
    private class DoublyLinkedListIterator implements Iterator<T> {
        private DoublyNode<T> current = first;

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
    //

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyLinkedList<?> that = (DoublyLinkedList<?>) o;
        return length == that.length && Objects.equals(first, that.first) && Objects.equals(last, that.last) && this.containsAll((MyDoublyLinkedList<T>) o,true);
    }
    @Override
    public int size() {
        return length;
    }
    @Override
    public void clear(){
        this.first  = null;
        this.last   = null;
        this.length = 0;
    }
    @Override
    public boolean removeAll(MyDoublyLinkedList<T> ls) {
        boolean flag = false;
        for (T item : ls){
            if(this.remove(item)){
                flag = true;
            }
        }
        return flag;
    }

}
