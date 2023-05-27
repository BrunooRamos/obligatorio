package uy.edu.um.prog2.entities.tads.hash;

import uy.edu.um.prog2.exceptions.treeBST.ErrorControlado;
import uy.edu.um.prog2.interfaces.hash.MyHash;

public class MyHashImpl<K, V> implements MyHash<K, V> {

    private HashNode[] tablaHash;
    private int size;

    public MyHashImpl(int tamano) {
        this.tablaHash = new HashNode[tamano];
        this.size = tamano;
    }
    @Override
    public void put(K key, V value) throws ErrorControlado {
        int posicion = key.hashCode() % size;
        HashNode<K, V> nodo = new HashNode<>(key, value);

        if (tablaHash[posicion] == null || tablaHash[posicion].isBorrado()){
            tablaHash[posicion] = nodo;
        } else {
            int attempt = 1;
            int nuevaPosicion = (key.hashCode() + linearColision(attempt)) % size;

            while (tablaHash[nuevaPosicion] != null &&
                    !tablaHash[nuevaPosicion].isBorrado() &&
                    attempt <= size){
                attempt++;
                nuevaPosicion = (key.hashCode() + linearColision(attempt)) % size;
            }

            if (attempt > size){
                throw new ErrorControlado("El hashtable no tiene tanto size");
            }

            if (this.contains(key)){
                throw new ErrorControlado("La key ya existe");
            } else {
                tablaHash[nuevaPosicion] = nodo;
            }
        }
    }


    private int linearColision(int attempt){
        return attempt;
    }
    @Override
    public boolean contains(Object key) {
        int posicion = key.hashCode() % size;

        if (tablaHash[posicion] != null && tablaHash[posicion].getKey().equals(key)){
            return true;
        } else {

            int attempt = 1;
            int nuevaPosicion = (key.hashCode() + linearColision(attempt)) % size;

            while (tablaHash[nuevaPosicion] != null &&
                    attempt <= size) {
                if (tablaHash[nuevaPosicion].getKey().equals(key)) {
                    return true;
                }
                attempt++;
                nuevaPosicion = (key.hashCode() + linearColision(attempt)) % size;
            }
        }

        return false;
    }

    public int find(K key){

        if (contains(key)){
            int posicion = key.hashCode() % size;

            if (tablaHash[posicion] != null && tablaHash[posicion].getKey().equals(key)){
                return posicion;
            } else {

                int attempt = 1;
                int nuevaPosicion = (key.hashCode() + linearColision(attempt)) % size;

                while (tablaHash[nuevaPosicion] != null &&
                        attempt <= size) {
                    if (tablaHash[nuevaPosicion].getKey().equals(key)) {
                        return nuevaPosicion;
                    }
                    attempt++;
                    nuevaPosicion = (key.hashCode() + linearColision(attempt)) % size;
                }
            }

        }

        return -1;
    }

    @Override
    public void remove(K clave) throws ErrorControlado {
        int posicion = find(clave);

        if (posicion != -1) {
            this.tablaHash[posicion].setIsBorrado(true);
        } else {
            throw new ErrorControlado("Posicion no encotrada");
        }

    }


    public void printHashTable() {
        for (int i = 0; i < size; i++) {
            if (tablaHash[i] != null) {
                System.out.println("Posición " + i + ": " + tablaHash[i].getKey() + " => " + tablaHash[i].getData() + " => " + tablaHash[i].isBorrado());
            }
        }
    }


}
