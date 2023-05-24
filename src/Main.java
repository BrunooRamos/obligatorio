import uy.edu.um.prog2.entities.tads.linkedlist.LinkedList;
import uy.edu.um.prog2.exceptions.linkedlist.EmptyListException;

public class Main {
    public static void main(String[] args) throws EmptyListException {

        operacionesLinkedList();

    }
    public static void operacionesLinkedList() throws EmptyListException {
        //generar instancia de lista
        LinkedList<String> ls = new LinkedList<String>();

        //test add/get
        ls.add("Hola");
        ls.add("mundo");
        ls.add("2");

        //Puesto por BRUNO
        ls.addPosition("23",0);

        System.out.println("Item at position 0: " + ls.get(0));
        System.out.println("Item at position 1: " + ls.get(1));

        //test remove
        ls.remove(3);
        System.out.println("Item at position 0: " + ls.get(0));

        //test has
        System.out.println("List has item 'mundo':  " + ls.has("mundo"));
        System.out.println("List has item 'hola': " + ls.has("hola"));

        //test get/check length
        System.out.println(ls.getLength());
        System.out.println(ls.checkLength());

        //test add First/Last
        ls.addFirst("Hola");
        ls.addLast("!!!");
        System.out.println("First value: "+ls.get(0));
        System.out.println("Last value: "+ls.get(ls.getLength() - 1));

        //test imprimir
        ls.imprimir();

    }
}

