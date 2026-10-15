package lab09;

import java.util.Iterator;

// EXPLAIN: implementing Iterable lets the list work in a for-each loop
public class MyLinkedList<T> implements Iterable<T> {

    // EXPLAIN: STATIC nested class; a Node needs no outer list object
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    // EXPLAIN: INNER class; it uses the outer object's 'head' field
    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() { return current != null; }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        for (String s : list) {
            System.out.println(s);
        }
    }
}