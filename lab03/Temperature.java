package lab03;

public class Temperature {
    // EXPLAIN: internal unit is kelvin; callers never see this detail
    private final double kelvin;

    private Temperature(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Below absolute zero");
        }
        this.kelvin = kelvin;
    }

    public static Temperature fromCelsius(double c) { return new Temperature(c + 273.15); }
    public static Temperature fromFahrenheit(double f) { return new Temperature((f - 32) * 5.0 / 9.0 + 273.15); }

    public double getCelsius() { return kelvin - 273.15; }
    public double getFahrenheit() { return getCelsius() * 9.0 / 5.0 + 32; }

    public static void main(String[] args) {
        Temperature t = Temperature.fromCelsius(25);
        System.out.printf("%.1f C = %.1f F%n", t.getCelsius(), t.getFahrenheit());

        try {
            Temperature.fromCelsius(-300);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}