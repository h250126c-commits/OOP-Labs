package lab10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveLines {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        // EXPLAIN: try-with-resources closes the Scanner automatically
        try (Scanner in = new Scanner(System.in)) {
            for (int i = 1; i <= 5; i++) {
                System.out.print("Line " + i + ": ");
                lines.add(in.nextLine());
            }
        }

        Path path = Path.of("lines.txt");
        try {
            // EXPLAIN: Files.write creates or overwrites the file; it throws a checked IOException
            Files.write(path, lines);
            System.out.println("--- Read back ---");
            for (String line : Files.readAllLines(path)) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File problem: " + e.getMessage());
        }
    }
}