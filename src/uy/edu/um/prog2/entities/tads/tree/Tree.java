package uy.edu.um.prog2.entities.tads.tree;


import uy.edu.um.prog2.entities.tads.linkedlist.MyLinkedListImp;
import uy.edu.um.prog2.interfaces.tree.MyTree;
import uy.edu.um.prog2.exceptions.treeBST.ErrorControlado;

public class Tree implements MyTree {

    private NodoArbol raiz;

    public void setRaiz(NodoArbol<Object, Object> raiz) {
        this.raiz = raiz;
    }

    public NodoArbol<Object, Object> getRaiz() {
        return raiz;
    }

    @Override
    public Object find(Object key) throws ErrorControlado {
        //Si la raiz esta vacia, retorna null
        if (raiz == null) return null;
        Object data = null;

        //Si la key es igual a la key de la raiz, me retrona la data de la raiz.
        if (raiz.getKey().equals(key)) {
            data = raiz.getData();
            return data;
        }
        //Sino, se fija que el nodo derecho sea distinto de null y si lo es, verifica que la key que busco no sea la del nodo.
        if (raiz.nodoDerecho != null) {

                //Sino es igual, debo buscar en el hijo de este nodo derecho.
                //Me creo un nuevo arbol, con el objetivo de no sobreescribir el arbol anterior.
                Tree arbolTemp = new Tree();
                //La raiz del nuevo arbol es el nodo derecho.
                arbolTemp.setRaiz(raiz.nodoDerecho);
                //Aplico el algoritmo recurisvamente para que ejecute todo esto de nuevo, considerando esta nueva raiz.
                data = arbolTemp.find(key);
                //Si la data no es null, quiere decir que la encontro entonces retorno dicha data.
                if (data != null) {
                    return data;

            }
        }
        //De lo contrario, sigo buscando y aplico la misma logica que arriba pero en el nodo izquierdo.
        if (raiz.nodoIzquierdo != null) {

                Tree arbolTemp = new Tree();
                arbolTemp.setRaiz(raiz.nodoIzquierdo);
                data = arbolTemp.find(key);
                if (data != null) {
                    return data;

            }
        }
        return null;
    }


    //Este algoritmo es similar al anterior, pero lo uso con el objetivo de usar el insert.
    public NodoArbol findNodo(Object key) throws ErrorControlado {
        if (raiz == null) return null;
        NodoArbol data = null;

        if (raiz.getKey().equals(key)) {
            data = raiz;
            return data;
        }

        if (raiz.nodoDerecho != null) {
                Tree arbolTemp = new Tree();
                arbolTemp.setRaiz(raiz.nodoDerecho);
                data = arbolTemp.findNodo(key);
                if (data != null) {
                    return data;
            }
        }

        if (raiz.nodoIzquierdo != null) {
                Tree arbolTemp = new Tree();
                arbolTemp.setRaiz(raiz.nodoIzquierdo);
                data = arbolTemp.findNodo(key);
                if (data != null) {
                    return data;
                }
        }
        return null;
    }

    @Override
    public void insert(Object key, Object data, Object parentKey) throws ErrorControlado {
        NodoArbol nodoArbol = new NodoArbol(key, data, parentKey);
        //Me fijo que el primer elemento sea null y ademas que el parent key sea null (por ser raiz)
        if (raiz == null) {
            if (parentKey != null) {
                throw new ErrorControlado("El arbol esta vacio");
            } else {
                raiz = nodoArbol;
            }
            //Si no es el primero, busco el nodo que tenga el mismo parentKey con el algoritmo anterior y veo que pasa con los nodos derechos e izquierdos.
        } else {
            NodoArbol nodoPadre = findNodo(parentKey);
            if (nodoPadre == null) {
                throw new ErrorControlado("El padre no existe");
            }
            if (nodoPadre.nodoIzquierdo == null) {
                nodoPadre.nodoIzquierdo = nodoArbol;
            } else if (nodoPadre.nodoDerecho == null) {
                nodoPadre.nodoDerecho = nodoArbol;
            } else {
                //Este error se lanza en caso de que el arbol ya tenga dos hijos (recordar que es un arbol binario)
                throw new ErrorControlado("El padre ya tiene dos hijos");
            }
        }
    }


    public NodoArbol findDaddy(Object key) throws ErrorControlado {
        if (raiz == null) return null;
        NodoArbol data = null;

        if (raiz.getKey().equals(key)) {
            return null;
        }
        if (raiz.nodoIzquierdo != null) {
            if (raiz.nodoIzquierdo.getKey().equals(key)){
                return raiz;
            } else {
                Tree arbolTemp = new Tree();
                arbolTemp.setRaiz(raiz.nodoIzquierdo);
                data = arbolTemp.findDaddy(key);
                if (data != null) {
                    return data;
                }
            }
        }
        if (raiz.nodoDerecho != null) {
            if (raiz.nodoDerecho.getKey().equals(key)){
                return raiz;
            } else {
                Tree arbolTemp = new Tree();
                arbolTemp.setRaiz(raiz.nodoDerecho);
                data = arbolTemp.findDaddy(key);
                if (data != null) {
                    return data;
                }
            }
        }
        return null;
    }

    @Override
    public void delete(Object key) throws ErrorControlado {
        NodoArbol nodoArbol = findDaddy(key);
        if (nodoArbol != null){
            if (nodoArbol.nodoIzquierdo != null){
                if (nodoArbol.nodoIzquierdo.getKey().equals(key)){
                    nodoArbol.nodoIzquierdo = null;
                }
            }
            if (nodoArbol.nodoDerecho != null) {
                if (nodoArbol.nodoDerecho.getKey().equals(key)){
                    nodoArbol.nodoDerecho = null;
                }
            }
        } else {
            throw new ErrorControlado("No hay nodo");
        }

    }

    @Override
    public Integer size() throws ErrorControlado {
        Integer counter = 0;

        if (raiz == null) return counter;

        counter = counter + 1;
        if (raiz.nodoIzquierdo != null) {
            Tree arbolTemp = new Tree();
            arbolTemp.setRaiz(raiz.nodoIzquierdo);
            counter = counter + arbolTemp.size();
        }

        if (raiz.nodoDerecho != null) {
            Tree arbolTemp = new Tree();
            arbolTemp.setRaiz(raiz.nodoDerecho);
            counter = counter + arbolTemp.size();
        }

        return counter;
    }

    @Override
    public Integer countLeaf() throws ErrorControlado {
        Integer counter = 0;

        if (raiz == null) return counter;

        if (raiz.nodoDerecho == null && raiz.nodoIzquierdo ==null){
            return 1;
        }
        if (raiz.nodoIzquierdo != null) {
            Tree arbolTemp = new Tree();
            arbolTemp.setRaiz(raiz.nodoIzquierdo);
            counter += arbolTemp.countLeaf();
        }

        if (raiz.nodoDerecho != null) {
            Tree arbolTemp = new Tree();
            arbolTemp.setRaiz(raiz.nodoDerecho);
            counter += arbolTemp.countLeaf();
        }


        return counter;
    }

    @Override
    public Integer countCompleteElements() throws ErrorControlado {
        Integer counter = 0;

        if (raiz == null || raiz.nodoDerecho == null && raiz.nodoIzquierdo == null) return counter;

        if (raiz.nodoDerecho != null && raiz.nodoIzquierdo != null) {
             counter += 1;
        }

        if(raiz.nodoIzquierdo != null) {
            Tree arbolTemp = new Tree();
            arbolTemp.setRaiz(raiz.nodoIzquierdo);
            counter += arbolTemp.countCompleteElements();
        }
        if (raiz.nodoDerecho != null) {
            Tree arbolTemp = new Tree();
            arbolTemp.setRaiz(raiz.nodoDerecho);
            counter += arbolTemp.countCompleteElements();
        }


        return counter;
    }

    @Override
    public MyLinkedListImp inOrder() {
        MyLinkedListImp keyVisitados = new MyLinkedListImp();

        if (raiz == null) return keyVisitados;

        inOrderRec(raiz, keyVisitados);

        return keyVisitados;
    }

    private void inOrderRec(NodoArbol nodo, MyLinkedListImp keyVisitados){
        if (nodo == null) return;
        // Recorrer el izquierdo
        inOrderRec(nodo.nodoIzquierdo, keyVisitados);
        // Hijo
        keyVisitados.add(nodo.getKey());
        // Recorrer el derecho
        inOrderRec(nodo.nodoDerecho, keyVisitados);
    }

    @Override
    public MyLinkedListImp preOrder(){
        MyLinkedListImp keyVisitados = new MyLinkedListImp();

        if (raiz == null) return keyVisitados;

        preOrderRec(raiz, keyVisitados);

        return keyVisitados;
    }

    private void preOrderRec(NodoArbol nodo, MyLinkedListImp keyVisitados){
        if (nodo == null) return;
        // Hijo
        keyVisitados.add(nodo.getKey());
        // Recorrer el izquierdo
        preOrderRec(nodo.nodoIzquierdo, keyVisitados);
        // Recorrer el derecho
        preOrderRec(nodo.nodoDerecho, keyVisitados);
    }

    @Override
    public MyLinkedListImp postOrder() {
        MyLinkedListImp keyVisitados = new MyLinkedListImp();

        if (raiz == null) return keyVisitados;

        postOrderRec(raiz, keyVisitados);

        return keyVisitados;
    }

    private void postOrderRec(NodoArbol nodo, MyLinkedListImp keyVisitados) {
        if (nodo == null) return;
        // Recorrer el izquierdo
        postOrderRec(nodo.nodoIzquierdo, keyVisitados);
        // Recorrer el derecho
        postOrderRec(nodo.nodoDerecho, keyVisitados);
        // Hijo
        keyVisitados.add(nodo.getKey());
    }


}
