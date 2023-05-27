package uy.edu.um.prog2.entities.tads.treeBST;


import uy.edu.um.prog2.entities.tads.linkedlist.MyLinkedListImp;
import uy.edu.um.prog2.exceptions.treeBST.ErrorControlado;
import uy.edu.um.prog2.interfaces.treeBST.MyBinarySearchTree;

public class TreeBST<K,T> implements MyBinarySearchTree {
    private NodeBST raiz;
    public void setRaiz(NodeBST raiz) {this.raiz = raiz;}
    public NodeBST getRaiz() {return raiz;}

    @Override
    public void insert(Comparable key, Object data) {
        NodeBST nodo = new NodeBST(key,data);

        if (raiz==null){
            raiz = nodo;
        } else {
            if (raiz.compareTo(nodo)>0){
                if (raiz.nodoIzquierdo == null){
                    raiz.nodoIzquierdo = nodo;
                } else {
                    TreeBST arbolbinario = new TreeBST();
                    arbolbinario.setRaiz(raiz.nodoIzquierdo);
                    arbolbinario.insert(key, data);
                }
            } else {
                if (raiz.nodoDerecho == null){
                    raiz.nodoDerecho = nodo;
                } else {
                    TreeBST arbolbinario = new TreeBST();
                    arbolbinario.setRaiz(raiz.nodoDerecho);
                    arbolbinario.insert(key, data);
                }
            }
        }
    }
    @Override
    public Object find(Comparable key) {
        NodeBST temp = new NodeBST(key,0);
        Object data = new Object();

        if (raiz == null){
            return null;
        }

        if (raiz.compareTo(temp) >0){
            if (raiz.nodoIzquierdo!=null){
                TreeBST arbolBinario = new TreeBST();
                arbolBinario.setRaiz(raiz.nodoIzquierdo);
                return arbolBinario.find(key);
            }
        } else if (raiz.compareTo(temp) <0) {
            if (raiz.nodoDerecho!=null){
                TreeBST arbolBinario = new TreeBST();
                arbolBinario.setRaiz(raiz.nodoDerecho);
                return arbolBinario.find(key);
            }
        } else {
            data = raiz.getData();
        }
        return data;
    }

    public NodeBST findPadre(Object key) throws ErrorControlado {
        if (raiz == null) return null;
        NodeBST data = null;

        if (raiz.getKey().equals(key)) {
            return null;
        }
        if (raiz.nodoIzquierdo != null) {
            if (raiz.nodoIzquierdo.getKey().equals(key)){
                return raiz;
            } else {
                TreeBST arbolTemp = new TreeBST();
                arbolTemp.setRaiz(raiz.nodoIzquierdo);
                data = arbolTemp.findPadre(key);
                if (data != null) {
                    return data;
                }
            }
        }
        if (raiz.nodoDerecho != null) {
            if (raiz.nodoDerecho.getKey().equals(key)){
                return raiz;
            } else {
                TreeBST arbolTemp = new TreeBST();
                arbolTemp.setRaiz(raiz.nodoDerecho);
                data = arbolTemp.findPadre(key);
                if (data != null) {
                    return data;
                }
            }
        }
        return null;
    }

    public NodeBST findNodo(Comparable key) throws ErrorControlado {
        NodeBST temp = new NodeBST(key,0);
        NodeBST data = null;

        if (raiz == null){
            return null;
        }

        if (raiz.compareTo(temp) >0){
            if (raiz.nodoIzquierdo!=null){
                TreeBST arbolBinario = new TreeBST();
                arbolBinario.setRaiz(raiz.nodoIzquierdo);
                return arbolBinario.findNodo(key);
            }
        } else if (raiz.compareTo(temp) <0) {
            if (raiz.nodoDerecho!=null){
                TreeBST arbolBinario = new TreeBST();
                arbolBinario.setRaiz(raiz.nodoDerecho);
                return arbolBinario.findNodo(key);
            }
        } else {
            data = raiz;
        }
        if (data == null){
            throw new ErrorControlado("No hay tal nodo");
        } return data;
    }

    @Override
    public void delete(Object key) throws ErrorControlado {
        NodeBST nodoPadre = findPadre(key);
        NodeBST nodoABorrar = findNodo((Comparable) key);

        if (nodoABorrar.nodoIzquierdo == null && nodoABorrar.nodoDerecho == null) {
            // Eliminar un nodo hoja.
            if (nodoPadre != null) {
                if (nodoPadre.nodoIzquierdo != null) {
                    if (nodoPadre.nodoIzquierdo.getKey().equals(key)) {
                        nodoPadre.nodoIzquierdo = null;
                    }
                } else if (nodoPadre.nodoDerecho != null) {
                    if (nodoPadre.nodoDerecho.getKey().equals(key)) {
                        nodoPadre.nodoDerecho = null;
                    }
                }
            } else {
                throw new ErrorControlado("No hay nodo");
            }
        } else {
            // Eliminación de un nodo con un hijo.
            NodeBST hijo = (nodoABorrar.nodoIzquierdo != null) ? nodoABorrar.nodoIzquierdo : nodoABorrar.nodoDerecho;

            if (nodoPadre != null) {
                if (nodoPadre.nodoIzquierdo != null) {
                    if (nodoPadre.nodoIzquierdo.getKey().equals(key)) {
                        nodoPadre.nodoIzquierdo = hijo;
                    }
                } else if (nodoPadre.nodoDerecho != null) {
                    if (nodoPadre.nodoDerecho.getKey().equals(key)) {
                        nodoPadre.nodoDerecho = hijo;
                    }
                }
            } else {
                // El nodo a borrar es la raíz del árbol.
                nodoABorrar.setKey(hijo.getKey());
                nodoABorrar.setData(hijo.getData());
                nodoABorrar.nodoIzquierdo = hijo.nodoIzquierdo;
                nodoABorrar.nodoDerecho = hijo.nodoDerecho;
            }
        }
    }

    private NodeBST getSucesor(NodeBST node) {
        NodeBST current = node;
        while (current.nodoIzquierdo != null) {
            current = current.nodoIzquierdo;
        }
        return current;
    }


    public MyLinkedListImp inOrder(){
        MyLinkedListImp keyVisitados = new MyLinkedListImp();

        if (raiz == null) return keyVisitados;

        inOrderRec(raiz, keyVisitados);

        return keyVisitados;
    }
    private void inOrderRec(NodeBST nodo, MyLinkedListImp keyVisitados){
        if (nodo == null) return;
        // Recorrer el izquierdo
        inOrderRec(nodo.nodoIzquierdo, keyVisitados);
        // Hijo
        keyVisitados.add(nodo.getKey());
        // Recorrer el derecho
        inOrderRec(nodo.nodoDerecho, keyVisitados);
    }

    public MyLinkedListImp preOrder(){
        MyLinkedListImp keyVisitados = new MyLinkedListImp();

        if (raiz == null) return keyVisitados;

        preOrderRec(raiz, keyVisitados);

        return keyVisitados;
    }
    private void preOrderRec(NodeBST nodo, MyLinkedListImp keyVisitados){
        if (nodo == null) return;
        // Hijo
        keyVisitados.add(nodo.getKey());
        // Recorrer el izquierdo
        preOrderRec(nodo.nodoIzquierdo, keyVisitados);
        // Recorrer el derecho
        preOrderRec(nodo.nodoDerecho, keyVisitados);
    }

    public MyLinkedListImp postOrder(){
        MyLinkedListImp keyVisitados = new MyLinkedListImp();

        if (raiz == null) return keyVisitados;

        postOrderRec(raiz, keyVisitados);

        return keyVisitados;
    }
    private void postOrderRec(NodeBST nodo, MyLinkedListImp keyVisitados){
        if (nodo == null) return;
        // Recorrer el izquierdo
        postOrderRec(nodo.nodoIzquierdo, keyVisitados);
        // Recorrer el derecho
        postOrderRec(nodo.nodoDerecho, keyVisitados);
        // Hijo
        keyVisitados.add(nodo.getKey());
    }


}
