package lab05;

class Parent {
    String type = "Parent field";
    void who() { System.out.println("Parent method"); }
}

class Child extends Parent {
    String type = "Child field";   // hides the field, does not override it
    @Override void who() { System.out.println("Child method"); }
}

public class FieldVsMethod {
    public static void main(String[] args) {
        Parent p = new Child();   // declared type Parent, actual object Child
        p.who();                  // method: follows the ACTUAL object
        System.out.println(p.type);   // field: follows the DECLARED type
    }
}
