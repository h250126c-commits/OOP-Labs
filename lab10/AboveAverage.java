package lab10;

import java.util.List;

record Student(String name, double mark) { }

public class AboveAverage {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Tariro", 78),
                new Student("Farai", 55),
                new Student("Rudo", 91),
                new Student("Kuda", 62),
                new Student("Chipo", 84));

        // EXPLAIN: average() returns an OptionalDouble, so orElse gives a default if the list is empty
        double average = students.stream()
                .mapToDouble(Student::mark)
                .average()
                .orElse(0);

        System.out.printf("Class average: %.1f%n", average);

        students.stream()
                .filter(s -> s.mark() > average)
                .map(Student::name)
                .sorted()
                .forEach(System.out::println);
    }
}