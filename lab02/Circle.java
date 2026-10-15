package lab02;

public class Circle {
    // EXPLAIN: static field -> ONE copy shared by all Circle objects
    private static int count = 0;

    // EXPLAIN: instance field -> each Circle has its own radius
    private double radius;

    // EXPLAIN: constructor with a parameter; this.radius = field, radius = parameter
    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    // EXPLAIN: no-argument constructor chains to the one above using this(...)
    public Circle() {
        this(1.0);
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    // EXPLAIN: static method belongs to the class, so call it as Circle.getCount()
    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle();   // radius defaults to 1.0
        Circle c3 = new Circle(2.5);

        System.out.printf("c1 area = %.2f%n", c1.area());
        System.out.printf("c2 area = %.2f%n", c2.area());
        System.out.printf("c3 area = %.2f%n", c3.area());
        System.out.println("Circles created: " + Circle.getCount());
    }
}
