package lab05;

public class PrintDemo {
    // EXPLAIN: same method name, different parameter types -> overloading, resolved at compile time
    static void print(int x)      { System.out.println("int: " + x); }
    static void print(double x)   { System.out.println("double: " + x); }
    static void print(String x)   { System.out.println("String: " + x); }
    static void print(int[] x)    { System.out.println("int[]: " + java.util.Arrays.toString(x)); }

    public static void main(String[] args) {
        print(5);
        print(2.5);
        print("Hello");
        print(new int[]{1, 2, 3});
    }
}