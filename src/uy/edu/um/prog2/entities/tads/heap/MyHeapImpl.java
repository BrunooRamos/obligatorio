package uy.edu.um.prog2.entities.tads.heap;


import uy.edu.um.prog2.exceptions.heap.EmptyHeapException;
import uy.edu.um.prog2.interfaces.heap.MyHeap;

public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] listaElementos;
    private int size;

    public MyHeapImpl() {
        this.listaElementos = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void insertMAX(T element) {
        if (size == listaElementos.length) {
            resizeArray();
        }

        listaElementos[size] = element;
        size++;
        subir(size - 1);
    }

    @Override
    public T deleteMAX() {
        if (isEmpty()) {
            throw new EmptyHeapException("Esta vacio, no se puede borrar nada");
        }

        T borrado = (T) listaElementos[0];
        swap(0, size-1);
        listaElementos[size-1] = null;
        size--;

        bajar();

        return borrado;
    }

    @Override
    public T get() {
        if (isEmpty()) {
            throw new EmptyHeapException("Heap is empty.");
        }
        return (T) listaElementos[0];
    }

    @Override
    public int size() {
        return size;
    }


    private void subir(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && compararNumeros((Integer) listaElementos[index], (Integer) listaElementos[parentIndex]) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }


    private void bajar() {
        int k = 0;
        int l = 2 * k + 1;

        while (l < size) {
            int max = l;
            int r = l + 1;

            if (r < size && (Integer) listaElementos[r] > (Integer) listaElementos[l]) {
                max = r;
            }

            if ((Integer) listaElementos[max] > (Integer) listaElementos[k]) {
                swap(max, k);
                k = max;
                l = 2 * k + 1;
            } else {
                break;
            }
        }
    }



    public int compararNumeros(int i, int j){
        return Integer.compare(i, j);
    }

    public void imprimir() {
        for (int i = 0; i < size; i++) {
            System.out.println(listaElementos[i]);
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void swap(int i, int j) {
        Object temp = listaElementos[i];
        listaElementos[i] = listaElementos[j];
        listaElementos[j] = temp;
    }

    //Sugerencia GPT
    private void resizeArray() {
        Object[] newArray = new Object[listaElementos.length * 2];
        System.arraycopy(listaElementos, 0, newArray, 0, size);
        listaElementos = newArray;
    }
}
