package lab08;

import java.util.Arrays;

public class BubbleSortDemo {
    // EXPLAIN: T extends Comparable<T> guarantees compareTo exists
    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 2, 9, 1};
        String[] words = {"pear", "apple", "zebra", "mango"};

        bubbleSort(nums);
        bubbleSort(words);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(words));

        // int[] raw = {3, 1, 2};
        // bubbleSort(raw);   // COMPILE ERROR: int is a primitive, not a reference type
    }
}