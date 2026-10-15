package lab03;

public class Student {
    // EXPLAIN: private -> no code outside this class can touch these directly
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        setMarks(marks);   // EXPLAIN: reuse the setter so the constructor also validates
    }

    public String getName() { return name; }

    public int getMarks() { return marks; }

    // EXPLAIN: setter validates, so a Student can never hold invalid marks
    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    // EXPLAIN: the grade is calculated on demand, not stored, so it can never go out of date
    public String getGrade() {
        if (marks >= 75) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }

    public static void main(String[] args) {
        Student s = new Student("Tariro", 82);
        System.out.println(s.getName() + ": " + s.getMarks() + " -> " + s.getGrade());

        s.setMarks(55);
        System.out.println(s.getName() + ": " + s.getMarks() + " -> " + s.getGrade());

        try {
            s.setMarks(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}