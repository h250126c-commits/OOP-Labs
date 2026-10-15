package lab07;

// extends Exception -> CHECKED: callers must catch it or declare throws
class InvalidAgeException extends Exception {
    private final int age;

    InvalidAgeException(String message, int age) {
        super(message);
        this.age = age;
    }

    int getAge() { return age; }
}

public class AgeValidation {

    // 'throws' warns callers they must handle this checked exception
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age must be between 0 and 120", age);
        }
        System.out.println("Age " + age + " is valid.");
    }

    public static void main(String[] args) {
        int[] testAges = {25, -5, 150, 120, 0};

        for (int age : testAges) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Invalid age " + e.getAge() + ": " + e.getMessage());
            }
        }
    }
}