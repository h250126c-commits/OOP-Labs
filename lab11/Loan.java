package lab11;

import java.time.LocalDate;

public class Loan {
    private final LibraryItem item;
    private final Member member;
    private final LocalDate dueDate;

    public Loan(LibraryItem item, Member member, LocalDate dueDate) {
        this.item = item;
        this.member = member;
        this.dueDate = dueDate;
    }

    public LibraryItem getItem() { return item; }
    public Member getMember() { return member; }
    public LocalDate getDueDate() { return dueDate; }

    public boolean isOverdue() { return LocalDate.now().isAfter(dueDate); }

    public String toCsv() { return item.getId() + "," + member.getId() + "," + dueDate; }

    @Override
    public String toString() {
        return item.getTitle() + " -> " + member.getName() + ", due " + dueDate;
    }
}