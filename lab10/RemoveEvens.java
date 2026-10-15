package lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveEvens {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));

        // EXPLAIN: a Predicate is a lambda that returns true/false
        Predicate<Integer> isEven = n -> n % 2 == 0;

        numbers.removeIf(isEven);
        System.out.println(numbers);
    }
}