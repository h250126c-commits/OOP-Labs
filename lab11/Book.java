package lab11;

public class Book extends LibraryItem {
    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);
        if (author == null || author.isBlank() || author.contains(",")) {
            throw new IllegalArgumentException("Valid author required (no commas)");
        }
        this.author = author.trim();
    }

    @Override public int loanPeriodDays() { return 14; }
    @Override public String type() { return "BOOK"; }
    @Override protected String extra() { return author; }

    @Override
    public String toString() { return super.toString() + " by " + author; }
}