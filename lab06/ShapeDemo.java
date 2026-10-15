package lab06;

abstract class Shape {
    abstract double area();
    abstract double perimeter();

    // concrete method shared by all shapes
    void describe() {
        System.out.printf("%-10s area = %.2f, perimeter = %.2f%n",
                getClass().getSimpleName(), area(), perimeter());
    }
}

class Circle extends Shape {
    private final double r;
    Circle(double r) { this.r = r; }

    @Override double area()      { return Math.PI * r * r; }
    @Override double perimeter() { return 2 * Math.PI * r; }
}

class Rectangle extends Shape {
    private final double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }

    @Override double area()      { return w * h; }
    @Override double perimeter() { return 2 * (w + h); }
}

class Square extends Shape {
    private final double side;
    Square(double side) { this.side = side; }

    @Override double area()      { return side * side; }
    @Override double perimeter() { return 4 * side; }
}

public class ShapeDemo {
    public static void main(String[] args) {
        // Shape s = new Shape();   // COMPILE ERROR: Shape is abstract

        Shape[] shapes = { new Circle(5), new Rectangle(4, 6), new Square(3) };

        for (Shape s : shapes) {
            s.describe();
        }
    }
}