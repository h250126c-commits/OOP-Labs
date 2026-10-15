package lab04;

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // EXPLAIN: written once here, inherited by Student and Teacher
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// EXPLAIN: Student IS-A Person, so it inherits display()
class Student extends Person {
    private String course;

    Student(String name, int age, String course) {
        super(name, age);   // EXPLAIN: runs Person's constructor first
        this.course = course;
    }

    String getCourse() { return course; }
}

class Teacher extends Person {
    private String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    String getSubject() { return subject; }
}

public class PersonDemo {
    public static void main(String[] args) {
        Student s = new Student("Tariro", 20, "Computer Science");
        Teacher t = new Teacher("Mr Moyo", 45, "Mathematics");

        s.display();
        System.out.println("Course: " + s.getCourse());
        t.display();
        System.out.println("Subject: " + t.getSubject());
    }
}