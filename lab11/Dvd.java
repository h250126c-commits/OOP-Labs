package lab11;

public class Dvd extends LibraryItem {
    private final int minutes;

    public Dvd(String id, String title, int minutes) {
        super(id, title);
        if (minutes <= 0) throw new IllegalArgumentException("Minutes must be positive");
        this.minutes = minutes;
    }

    @Override public int loanPeriodDays() { return 7; }   // EXPLAIN: polymorphism, DVDs are lent for less time
    @Override public String type() { return "DVD"; }
    @Override protected String extra() { return String.valueOf(minutes); }

    @Override
    public String toString() { return super.toString() + ", " + minutes + " min"; }
}