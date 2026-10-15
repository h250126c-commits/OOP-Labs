public class AliasDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 5;
        r1.height = 2;

        // EXPLAIN: r2 copies the REFERENCE, not the object, so r1 and r2 point to the same rectangle
        Rectangle r2 = r1;
        r2.width = 10;

        System.out.println("r1.width = " + r1.width);
    }
}
