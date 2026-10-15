package lab06;

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    String getName() { return name; }
    int getMarks()   { return marks; }

    // natural ordering: alphabetical by name
    @Override
    public int compareTo(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return name + "(" + marks + ")";
    }
}

// a separate ordering: highest marks first
class MarksComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return Integer.compare(b.getMarks(), a.getMarks());
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Chenai", 78),
            new Student("Anesu", 65),
            new Student("Blessing", 91),
            new Student("Tendai", 84)
        };

        Arrays.sort(students);   // uses compareTo (Comparable)
        System.out.println("By name:        " + Arrays.toString(students));

        Arrays.sort(students, new MarksComparator());   // uses the Comparator
        System.out.println("By marks (high): " + Arrays.toString(students));

        // same idea as a one-liner, lowest marks first
        Arrays.sort(students, Comparator.comparingInt(Student::getMarks));
        System.out.println("By marks (low):  " + Arrays.toString(students));
    }
}