package lab08;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of(
                "Tariro", "Farai", "Tariro", "Rudo", "Farai", "Kuda"));
        System.out.println("Original: " + names);

        // EXPLAIN: a Set cannot hold duplicates; LinkedHashSet also keeps insertion order
        Set<String> unique = new LinkedHashSet<>(names);
        System.out.println("Unique:   " + unique);

        List<String> cleaned = new ArrayList<>(unique);
        System.out.println("Back to a list: " + cleaned);
    }
}