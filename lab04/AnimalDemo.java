package lab04;

class Animal {
    protected String name;

    // EXPLAIN: only ONE constructor, and it needs a String. There is no no-argument constructor.
    Animal(String name) {
        this.name = name;
    }

    void speak() { System.out.println("..."); }
}

// BROKEN VERSION (does not compile, so it stays commented out):
// class Dog extends Animal { }
// Error: Java inserts super() automatically, but Animal has no Animal() constructor.

// FIXED VERSION:
class Dog extends Animal {
    Dog(String name) {
        super(name);   // EXPLAIN: explicitly pick the constructor that exists
    }

    @Override
    void speak() { System.out.println(name + " says Woof"); }
}

public class AnimalDemo {
    public static void main(String[] args) {
        Dog d = new Dog("Rex");
        d.speak();
    }
}
