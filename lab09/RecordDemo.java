package lab09;

// EXPLAIN: a record auto-generates the constructor, accessors, equals, hashCode and toString
record Student(String name, int age) { }

public class RecordDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Tariro", 20);
        Student s2 = new Student("Tariro", 20);
        Student s3 = new Student("Farai", 22);

        System.out.println(s1);                       // generated toString
        System.out.println("s1 equals s2? " + s1.equals(s2));   // compares VALUES
        System.out.println("s1 == s2? " + (s1 == s2));          // compares references
        System.out.println("s1 equals s3? " + s1.equals(s3));
        System.out.println("Name: " + s1.name());     // accessor is name(), not getName()
    }
}