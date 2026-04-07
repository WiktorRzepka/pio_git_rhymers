package edu.kis.vh.nursery.list;

/**
 * Klasa reprezentująca strukturę stosu dla liczb całkowitych.
 * Opiera się na liście dwukierunkowej Node.
 */
public class IntLinkedList {

    private static final int STACK_EMPTY=-1;
    private Node last;
    private int size;

    /**
     * Dodaje nowy element na szczyt stosu.
     * @param i wartość całkowita do dodania
     */
    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.setNext(new Node(i));
            last.getNext().setPrev(last);
            last = last.getNext();
        }
    }

    /**
     * Sprawdza czy struktura jest pusta.
     * @return true, jeśli struktura jest pusta, w przeciwnym wypadku false.
     */
    public boolean isEmpty() {
        return last == null;
    }

    /**
     * Sprawdza czy struktura jest pełna.
     * @return zawsze false - struktura jest dynamiczna
     */
    public boolean isFull() {
        return false;
    }

    /**
     * Zwraca wartość ostatnio dodanego elementu, bez usuwania go ze stosu.
     * @return wartość ostatnio dodanego elementu lub wartość STACK_EMPTY, jeśli struktura jest pusta.
     */
    public int top() {
        if (isEmpty())
            return STACK_EMPTY;
        return last.getValue();
    }

    /**
     * Usuwa ostatnio dodany element i go zwraca.
     * @return wartość ostatnio dodanego elementu lub wartość STACK_EMPTY, jeśli struktura jest pusta.
     */
    public int pop() {
        if (isEmpty())
            return STACK_EMPTY;
        int ret = last.getValue();
        last = last.getPrev();
        return ret;
    }

    /**
     * Zwraca referencję do ostatnio dodanego węzła do stosu.
     * @return obiekt klasy Node - ostatnio dodany węzeł lub null.
     */
    Node getLast() {
        return last;
    }
}

class Node {

    private final int value;
    private Node prev;
    private Node next;

    public Node(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}