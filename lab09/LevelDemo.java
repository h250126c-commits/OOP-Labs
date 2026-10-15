package lab09;

// EXPLAIN: an enum is a fixed set of constants, and it is type-safe
enum Level { LOW, MEDIUM, HIGH }

public class LevelDemo {
    static void advice(Level level) {
        // EXPLAIN: switch expression; no fall-through, and it returns a value
        String message = switch (level) {
            case LOW    -> "Relax, nothing urgent.";
            case MEDIUM -> "Keep an eye on it.";
            case HIGH   -> "Act now!";
        };
        System.out.println(level + ": " + message);
    }

    public static void main(String[] args) {
        for (Level l : Level.values()) {
            advice(l);
        }
    }
}