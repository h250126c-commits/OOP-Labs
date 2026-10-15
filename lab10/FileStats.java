package lab10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileStats {
    public static void main(String[] args) {
        Path path = Path.of("sample.txt");
        try {
            Files.write(path, List.of(
                    "Java is an object oriented language",
                    "Streams make collections easy",
                    "Files can be read line by line"));

            List<String> lines = Files.readAllLines(path);

            int words = 0;
            int chars = 0;
            for (String line : lines) {
                // EXPLAIN: split on whitespace; skip blank lines so they don't count as a word
                if (!line.isBlank()) {
                    words += line.trim().split("\\s+").length;
                }
                chars += line.length();
            }

            System.out.println("Lines: " + lines.size());
            System.out.println("Words: " + words);
            System.out.println("Characters (excluding line breaks): " + chars);
        } catch (IOException e) {
            System.out.println("File problem: " + e.getMessage());
        }
    }
}
