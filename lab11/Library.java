package lab11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private static final Path ITEMS_FILE = Path.of("items.csv");
    private static final Path MEMBERS_FILE = Path.of("members.csv");
    private static final Path LOANS_FILE = Path.of("loans.csv");

    // EXPLAIN: Maps keyed by id give fast lookup
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addItem(LibraryItem item) {
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException("Item id already exists: " + item.getId());
        }
        items.put(item.getId(), item);
    }

    public void addMember(Member member) {
        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException("Member id already exists: " + member.getId());
        }
        members.put(member.getId(), member);
    }

    public void borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = members.get(memberId);
        if (member == null) throw new IllegalArgumentException("No such member: " + memberId);
        LibraryItem item = items.get(itemId);
        if (item == null) throw new IllegalArgumentException("No such item: " + itemId);

        item.borrow(member);   // checks availability and the loan limit, may throw
        member.loanAdded();
        loans.add(new Loan(item, member, LocalDate.now().plusDays(item.loanPeriodDays())));
    }

    public void giveBack(String itemId) {
        Loan found = null;
        for (Loan l : loans) {
            if (l.getItem().getId().equals(itemId)) found = l;
        }
        if (found == null) throw new IllegalArgumentException("That item is not on loan: " + itemId);

        found.getItem().giveBack();
        found.getMember().loanReturned();
        loans.remove(found);
    }

    // EXPLAIN: streams filter and sort without modifying the original collections
    public List<Loan> overdueLoans() {
        return loans.stream().filter(Loan::isOverdue).toList();
    }

    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .toList();
    }

    public List<LibraryItem> allItems() {
        return items.values().stream().sorted(Comparator.comparing(LibraryItem::getId)).toList();
    }

    public List<Member> allMembers() {
        return members.values().stream().sorted(Comparator.comparing(Member::getId)).toList();
    }

    // ---------- persistence (Lab 10 pattern) ----------
    public void save() throws IOException {
        Files.write(ITEMS_FILE, items.values().stream().map(LibraryItem::toCsv).toList());
        Files.write(MEMBERS_FILE, members.values().stream().map(Member::toCsv).toList());
        Files.write(LOANS_FILE, loans.stream().map(Loan::toCsv).toList());
    }

    public void load() throws IOException {
        if (Files.exists(ITEMS_FILE)) {
            for (String line : Files.readAllLines(ITEMS_FILE)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                if (p[0].equals("BOOK")) addItem(new Book(p[1], p[2], p[3]));
                else if (p[0].equals("DVD")) addItem(new Dvd(p[1], p[2], Integer.parseInt(p[3])));
            }
        }
        if (Files.exists(MEMBERS_FILE)) {
            for (String line : Files.readAllLines(MEMBERS_FILE)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                addMember(new Member(p[0], p[1]));
            }
        }
        if (Files.exists(LOANS_FILE)) {
            for (String line : Files.readAllLines(LOANS_FILE)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                LibraryItem item = items.get(p[0]);
                Member member = members.get(p[1]);
                if (item == null || member == null) continue;
                item.setAvailable(false);
                member.loanAdded();
                loans.add(new Loan(item, member, LocalDate.parse(p[2])));
            }
        }
    }
}