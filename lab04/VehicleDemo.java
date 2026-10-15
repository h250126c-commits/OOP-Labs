package lab04;

class Vehicle {
    Vehicle() {
        System.out.println("Vehicle constructor");
    }
}

class Car extends Vehicle {
    Car() {
        // EXPLAIN: Java inserts super() here automatically
        System.out.println("Car constructor");
    }
}

class ElectricCar extends Car {
    ElectricCar() {
        System.out.println("ElectricCar constructor");
    }
}

public class VehicleDemo {
    
    public static void main(String[] args) {
        new ElectricCar();
    }
}