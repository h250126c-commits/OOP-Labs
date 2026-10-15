package lab07;

import java.util.Scanner;

public class SafeDivide {
    public static void main(String[] args) {
        // try-with-resources closes the Scanner automatically
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the first integer: ");
            int a = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter the second integer: ");
            int b = Integer.parseInt(sc.nextLine().trim());

            int result = a / b;     // ArithmeticException if b == 0
            System.out.println(a + " / " + b + " = " + result);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input: please enter whole numbers only.");
        } catch (ArithmeticException e) {
            System.out.println("Math error: cannot divide by zero.");
        } finally {
            System.out.println("Program finished.");
        }
    }
}