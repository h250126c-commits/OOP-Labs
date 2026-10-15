package lab11;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String ask(Scanner in, String label) {
        System.out.print(label + ": ");
        return in.nextLine().trim();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== Library Menu =====");
        System.out.println("1. Add book");
        System.out.println("2. Add DVD");
        System.out.println("3. Register member");
        System.out.println("4. Borrow item");
        System.out.println("5. Return item");
        System.out.println("6. List overdue items");
        System.out.println("7. Search by title");
        System.out.println("8. List all items and members");
        System.out.println("0. Save and exit");
        System.out.print("Choice: ");
    }

    public static void main(String[] args) {
        Library lib = new Library();
        try {
            lib.load();
        } catch (IOException e) {
            System.out.println("Could not load saved data: " + e.getMessage());
        }

        try (Scanner in = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMenu();
                String choice = in.nextLine().trim();
                try {
                    switch (choice) {
                        case "1" -> {
                            String id = ask(in, "Book id");
                            String title = ask(in, "Title");
                            String author = ask(in, "Author");
                            lib.addItem(new Book(id, title, author));
                            System.out.println("Book added.");
                        }
                        case "2" -> {
                            String id = ask(in, "DVD id");
                            String title = ask(in, "Title");
                            int minutes = Integer.parseInt(ask(in, "Length in minutes"));
                            lib.addItem(new Dvd(id, title, minutes));
                            System.out.println("DVD added.");
                        }
                        case "3" -> {
                            String id = ask(in, "Member id");
                            String name = ask(in, "Name");
                            lib.addMember(new Member(id, name));
                            System.out.println("Member registered.");
                        }
                        case "4" -> {
                            String memberId = ask(in, "Member id");
                            String itemId = ask(in, "Item id");
                            lib.borrow(memberId, itemId);
                            System.out.println("Borrowed successfully.");
                        }
                        case "5" -> {
                            lib.giveBack(ask(in, "Item id"));
                            System.out.println("Returned successfully.");
                        }
                        case "6" -> {
                            List<Loan> overdue = lib.overdueLoans();
                            if (overdue.isEmpty()) System.out.println("Nothing is overdue.");
                            else overdue.forEach(System.out::println);
                        }
                        case "7" -> {
                            List<LibraryItem> found = lib.searchByTitle(ask(in, "Search text"));
                            if (found.isEmpty()) System.out.println("No matches.");
                            else found.forEach(System.out::println);
                        }
                        case "8" -> {
                            System.out.println("-- Items --");
                            lib.allItems().forEach(System.out::println);
                            System.out.println("-- Members --");
                            lib.allMembers().forEach(System.out::println);
                        }
                        case "0" -> {
                            lib.save();
                            System.out.println("Saved. Goodbye.");
                            running = false;
                        }
                        default -> System.out.println("Invalid choice, try again.");
                    }
                } catch (ItemNotAvailableException | MemberLimitExceededException
                         | IllegalArgumentException e) {
                    // EXPLAIN: NumberFormatException is a kind of IllegalArgumentException
                    System.out.println("Error: " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("File problem: " + e.getMessage());
                }
            }
        }
    }
}