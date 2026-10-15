package lab03;

// EXPLAIN: final class -> nobody can subclass it and sneak in mutable behaviour
public final class ImmutablePerson {
    // EXPLAIN: final fields -> assigned once in the constructor, never changed
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.name = name;
        this.age = age;
    }

    // EXPLAIN: getters only, no setters
    public String getName() { return name; }
    public int getAge() { return age; }

    // EXPLAIN: to "change" a value we return a NEW object instead
    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(name, newAge);
    }

    public static void main(String[] args) {
        ImmutablePerson p1 = new ImmutablePerson("Chipo", 20);
        ImmutablePerson p2 = p1.withAge(21);
        System.out.println(p1.getName() + " " + p1.getAge());
        System.out.println(p2.getName() + " " + p2.getAge());
    }
}