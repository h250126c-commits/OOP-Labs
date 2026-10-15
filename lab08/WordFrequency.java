package lab08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "the cat and the dog and the bird";

        Map<String, Integer> freq = new HashMap<>();
        for (String word : text.split(" ")) {
            freq.merge(word, 1, Integer::sum);   // EXPLAIN: add 1, or start at 1
        }

        // EXPLAIN: a Map has no order, so copy the entries into a list and sort that
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((a, b) -> {
            int byCount = b.getValue().compareTo(a.getValue());   // highest count first
            if (byCount != 0) return byCount;
            return a.getKey().compareTo(b.getKey());              // ties: alphabetical
        });

        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}