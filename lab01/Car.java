public class Car {
    // EXPLAIN: instance variables define the STATE of every Car object
    String brand;
    int year;
    double mileage;

    // EXPLAIN: instance method defines BEHAVIOUR; it reads the object's own fields
    void display() {
        System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage + " km");
    }

    // EXPLAIN: returns true when the car is more than 25 years old
    boolean isAntique() {
        return 2026 - year > 25;
    }

    public static void main(String[] args) {
        // EXPLAIN: 'new' creates an object on the heap and returns a reference
        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.year = 2020;
        c1.mileage = 45000.5;

        Car c2 = new Car();
        c2.brand = "Ford";
        c2.year = 1995;
        c2.mileage = 210000;

        Car c3 = new Car();
        c3.brand = "Honda";
        c3.year = 2010;
        c3.mileage = 120000;

        c1.display();
        c2.display();
        c3.display();

        System.out.println(c1.brand + " antique? " + c1.isAntique());
        System.out.println(c2.brand + " antique? " + c2.isAntique());
        System.out.println(c3.brand + " antique? " + c3.isAntique());
    }
}