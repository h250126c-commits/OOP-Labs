package lab06;

interface Walker {
    default void hello() {
        System.out.println("Hello from Walker");
    }
}

interface Runner {
    default void hello() {
        System.out.println("Hello from Runner");
    }
}

// Both interfaces give hello() a default body, so Java cannot choose.
// The class MUST override hello() and decide what to do.
class Athlete implements Walker, Runner {
    @Override
    public void hello() {
        Walker.super.hello();    // explicitly call Walker's version
        Runner.super.hello();    // explicitly call Runner's version
        System.out.println("Athlete says hello");
    }
}

public class DefaultConflictDemo {
    public static void main(String[] args) {
        Athlete a = new Athlete();
        a.hello();
    }
}