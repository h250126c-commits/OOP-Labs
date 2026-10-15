package lab04;

import java.util.ArrayList;

// BAD DESIGN: inheritance. A BadStack IS-A ArrayList, so every ArrayList method is exposed.
class BadStack extends ArrayList<Integer> {
    void push(int x) { add(x); }
    int pop() { return remove(size() - 1); }
}

// GOOD DESIGN: composition. A GoodStack HAS-A list and exposes only stack operations.
class GoodStack {
    private final ArrayList<Integer> items = new ArrayList<>();

    void push(int x) { items.add(x); }
    int pop() { return items.remove(items.size() - 1); }
    int peek() { return items.get(items.size() - 1); }
    int size() { return items.size(); }
}

public class StackDemo {
    public static void main(String[] args) {
        BadStack bad = new BadStack();
        bad.push(1); bad.push(2); bad.push(3);
        System.out.println("BadStack pop: " + bad.pop());
        bad.add(0, 99);   // EXPLAIN: inserts at the BOTTOM, which a stack should never allow
        System.out.println("After bad.add(0, 99): " + bad);

        GoodStack good = new GoodStack();
        good.push(1); good.push(2); good.push(3);
        System.out.println("GoodStack pop: " + good.pop());
        System.out.println("GoodStack peek: " + good.peek());
        System.out.println("GoodStack size: " + good.size());
        // good.add(0, 99);   // COMPILE ERROR: GoodStack has no add method
    }
}