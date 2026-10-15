public class Person {
    String name;
    Address address;   // EXPLAIN: a field can itself be a reference to another object (HAS-A)

    public static void main(String[] args) {
        // Person WITH an address
        Address a = new Address();
        a.street = "12 Samora Machel Ave";
        a.city = "Harare";

        Person p1 = new Person();
        p1.name = "Stacey";
        p1.address = a;

        // EXPLAIN: chained dot operator: person -> address -> city
        System.out.println(p1.name + " lives in " + p1.address.city);

        // Person WITHOUT an address
        Person p2 = new Person();
        p2.name = "Anna";
        // p2.address was never assigned, so it is null

        // EXPLAIN: p2.address is null, so asking it for .city throws NullPointerException
        try {
            System.out.println(p2.address.city);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + p2.name
                    + " has no address, so .city cannot be read");
        }

        // EXPLAIN: the safe way is to check for null before using the reference
        if (p2.address != null) {
            System.out.println(p2.name + " lives in " + p2.address.city);
        } else {
            System.out.println(p2.name + " has no address recorded");
        }
    }
}