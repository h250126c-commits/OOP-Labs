package lab02;

public class Employee {
    // EXPLAIN: static counter, ONE copy shared by all Employee objects
    private static int counter = 0;

    // EXPLAIN: final -> each employee gets an id once and it never changes
    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    // EXPLAIN: instance block runs before the constructor body, for every new object
    {
        counter++;
        employeeId = counter;
    }

    // Constructor 1: full initialisation
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Constructor 2: chains to constructor 1 with a default salary
    public Employee(String name, String department) {
        this(name, department, 0.0);
    }

    // Constructor 3: chains to constructor 2 with a default department
    public Employee(String name) {
        this(name, "Unassigned");
    }

    // EXPLAIN: copy constructor makes a NEW, independent object with the same values
    public Employee(Employee other) {
        this(other.name, other.department, other.salary);
    }

    public static int getCount() {
        return counter;
    }

    public void display() {
        System.out.printf("ID %d: %s, %s, $%.2f%n", employeeId, name, department, salary);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tendai", "IT", 3500);
        Employee e2 = new Employee("Rudo", "HR");
        Employee e3 = new Employee("Farai");
        Employee e4 = new Employee(e1);   // copy of e1

        e1.display();
        e2.display();
        e3.display();
        e4.display();

        System.out.println("Total employees: " + Employee.getCount());
        System.out.println("e1 same object as e4? " + (e1 == e4));
    }
}