package lab02;

public class BlocksDemo {
    static { System.out.println("static block 1"); }
    { System.out.println("instance block 1"); }
    static { System.out.println("static block 2"); }
    { System.out.println("instance block 2"); }

    BlocksDemo() { System.out.println("constructor"); }

    public static void main(String[] args) {
        System.out.println("main starts");
        new BlocksDemo();
        new BlocksDemo();
    }
}
