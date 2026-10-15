package lab02;

public class Temperature {
    private final double celsius;

    // EXPLAIN: private constructor -> outsiders cannot use 'new', they must use the factories
    private Temperature(double celsius) {
        this.celsius = celsius;
    }

    // EXPLAIN: static factory methods; the NAME says what the number means
    public static Temperature fromCelsius(double c) {
        return new Temperature(c);
    }

    public static Temperature fromFahrenheit(double f) {
        return new Temperature((f - 32) * 5.0 / 9.0);
    }

    public double getCelsius() { return celsius; }

    public double getFahrenheit() { return celsius * 9.0 / 5.0 + 32; }

    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(100);
        Temperature t2 = Temperature.fromFahrenheit(32);

        System.out.printf("t1: %.1f C = %.1f F%n", t1.getCelsius(), t1.getFahrenheit());
        System.out.printf("t2: %.1f C = %.1f F%n", t2.getCelsius(), t2.getFahrenheit());
    }
}