package lab05;

class Animal {
    void sound() { System.out.println("Some sound"); }
}

class Cat extends Animal {
    @Override void sound() { System.out.println("Meow"); }
}

class Cow extends Animal {
    @Override void sound() { System.out.println("Moo"); }
}

class Duck extends Animal {
    @Override void sound() { System.out.println("Quack"); }
}

public class AnimalSounds {
    public static void main(String[] args) {
        // EXPLAIN: upcasting -> one array type holds different subclass objects
        Animal[] animals = { new Cat(), new Cow(), new Duck() };

        for (Animal a : animals) {
            a.sound();   // EXPLAIN: the JVM picks the version from the ACTUAL object at run time
        }
    }
}
