package lab11;

// EXPLAIN: abstract class holds the shared state; subclasses supply the differences
public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Id required");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title required");
        if (id.contains(",") || title.contains(",")) {
            throw new IllegalArgumentException("Commas are not allowed (they break the CSV files)");
        }
        this.id = id.trim();
        this.title = title.trim();
    }

    // EXPLAIN: abstract methods, so each subclass must provide its own version
    public abstract int loanPeriodDays();
    public abstract String type();
    protected abstract String extra();

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    void setAvailable(boolean available) { this.available = available; }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if (!available) {
            throw new ItemNotAvailableException(title + " is already on loan");
        }
        if (member.getActiveLoans() >= Member.MAX_LOANS) {
            throw new MemberLimitExceededException(
                    member.getName() + " already has " + Member.MAX_LOANS + " loans");
        }
        available = false;
    }

    @Override
    public void giveBack() {
        available = true;
    }

    public String toCsv() {
        return type() + "," + id + "," + title + "," + extra();
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%s)", type(), id, title,
                available ? "available" : "on loan");
    }
}