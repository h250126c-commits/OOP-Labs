package lab08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStats {
    public static void main(String[] args) {
        // EXPLAIN: program to the interface (List), create with ArrayList
        List<Integer> numbers = new ArrayList<>();
        int[] values = {5, 12, 8, 3, 21, 7, 15, 9, 1, 10};
        for (int v : values) {
            numbers.add(v);   // EXPLAIN: autoboxing converts int to Integer
        }

        int sum = 0;
        int max = numbers.get(0);
        for (int n : numbers) {
            sum += n;
            if (n > max) max = n;
        }

        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);

        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);
    }
}