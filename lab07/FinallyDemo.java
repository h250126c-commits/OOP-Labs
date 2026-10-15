package lab07;

public class FinallyDemo {

    // Case 1: return inside try, print inside finally
    static int test() {
        try {
            System.out.println("in try");
            return 1;
        } finally {
            System.out.println("in finally");
        }
    }

    // Case 2: finally changes the variable AFTER the return value is chosen
    static int modify() {
        int x = 10;
        try {
            return x;
        } finally {
            x = 99;
            System.out.println("finally set x to " + x);
        }
    }

    // Case 3: return inside finally (bad practice, shown only to explain it)
    @SuppressWarnings("finally")
    static int override() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println("test() returned " + test());
        System.out.println("modify() returned " + modify());
        System.out.println("override() returned " + override());
    }
}