package lab08;

import java.util.ArrayList;

// EXPLAIN: T is a type parameter chosen by the caller (Stack<String>, Stack<Integer>)
class Stack<T> {
    // EXPLAIN: composition, so the list's other methods are hidden
    private final ArrayList<T> items = new ArrayList<>();

    void push(T item) { items.add(item); }

    T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return items.remove(items.size() - 1);
    }

    T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return items.get(items.size() - 1);
    }

    boolean isEmpty() { return items.isEmpty(); }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.push("c");

        System.out.println("peek: " + s.peek());
        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());
        System.out.println("empty? " + s.isEmpty());
        System.out.println("pop: " + s.pop());
        System.out.println("empty? " + s.isEmpty());

        Stack<Integer> n = new Stack<>();
        n.push(10);
        n.push(20);
        int top = n.pop();   // no cast needed
        System.out.println("Integer stack popped: " + top);

        try {
            n.pop();
            n.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}