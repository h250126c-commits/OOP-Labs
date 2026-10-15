package lab10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

record Learner(String name, int roll, double gpa) {
    static Learner fromCsv(String line) {
        String[] p = line.split(",");
        return new Learner(p[0], Integer.parseInt(p[1]), Double.parseDouble(p[2]));
    }

    // EXPLAIN: the band is calculated from the GPA, not stored
    String band() {
        if (gpa >= 3.5) return "A";
        else if (gpa >= 3.0) return "B";
        else return "C";
    }

    String toCsv() { return name + "," + roll + "," + gpa; }
}

public class GradeBands {
    public static void main(String[] args) {
        Path csv = Path.of("learners.csv");
        try {
            Files.write(csv, List.of(
                    "Tariro,101,3.8", "Farai,102,3.1", "Rudo,103,3.9",
                    "Kuda,104,2.7", "Chipo,105,3.4", "Anesu,106,2.9"));

            List<Learner> learners = Files.readAllLines(csv).stream()
                    .filter(l -> !l.isBlank())
                    .map(Learner::fromCsv)
                    .toList();

            // EXPLAIN: groupingBy builds a Map from band to the learners in that band
            Map<String, List<Learner>> byBand = learners.stream()
                    .collect(Collectors.groupingBy(Learner::band, TreeMap::new, Collectors.toList()));

            for (Map.Entry<String, List<Learner>> e : byBand.entrySet()) {
                List<String> lines = e.getValue().stream().map(Learner::toCsv).toList();
                Path report = Path.of("band-" + e.getKey() + ".txt");
                Files.write(report, lines);
                System.out.println("Band " + e.getKey() + " -> " + report + " (" + lines.size() + " learners)");
            }
        } catch (IOException e) {
            System.out.println("File problem: " + e.getMessage());
        }
    }
}