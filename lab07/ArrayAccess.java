package lab07;

public class ArrayAccess {

    // returns the element at the given index, or -1 if the index is invalid
    static int getElement(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40};

        System.out.println("Index 2  -> " + getElement(numbers, 2));
        System.out.println("Index 5  -> " + getElement(numbers, 5));
        System.out.println("Index -1 -> " + getElement(numbers, -1));
        System.out.println("Program continues normally.");
    }
}