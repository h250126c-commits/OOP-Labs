package lab06;

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    private final String species;
    Bird(String species) { this.species = species; }

    @Override
    public void fly() {
        System.out.println(species + " flaps its wings and flies.");
    }
}

class Aeroplane implements Flyable {
    private final String model;
    Aeroplane(String model) { this.model = model; }

    @Override
    public void fly() {
        System.out.println(model + " accelerates down the runway and takes off.");
    }
}

public class FlyableDemo {
    public static void main(String[] args) {
        // program to the interface: the variable type is Flyable
        Flyable[] things = { new Bird("Eagle"), new Aeroplane("Boeing 737") };

        for (Flyable f : things) {
            f.fly();
        }
    }
}