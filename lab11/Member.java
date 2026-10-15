package lab11;

public class Member {
    public static final int MAX_LOANS = 3;

    private final String id;
    private final String name;
    private int activeLoans;

    public Member(String id, String name) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Id required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        if (id.contains(",") || name.contains(",")) {
            throw new IllegalArgumentException("Commas are not allowed");
        }
        this.id = id.trim();
        this.name = name.trim();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getActiveLoans() { return activeLoans; }

    // EXPLAIN: package-private, so only the library code can change the loan count
    void loanAdded() { activeLoans++; }
    void loanReturned() { activeLoans--; }

    public String toCsv() { return id + "," + name; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + activeLoans + "/" + MAX_LOANS + " loans)";
    }
}