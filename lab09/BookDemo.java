package lab09;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private final String isbn;
    private final String title;

    Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    // EXPLAIN: two books are equal when their ISBN is equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book other)) return false;
        return isbn.equals(other.isbn);
    }

    // EXPLAIN: equal objects MUST have equal hash codes, so hash the same field
    @Override
    public int hashCode() { return Objects.hash(isbn); }

    @Override
    public String toString() { return title + " (" + isbn + ")"; }
}

public class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book("978-0132350884", "Clean Code");
        Book b2 = new Book("978-0132350884", "Clean Code (2nd copy)");
        Book b3 = new Book("978-0134685991", "Effective Java");

        Set<Book> library = new HashSet<>();
        library.add(b1);
        library.add(b2);   // duplicate ISBN, so rejected
        library.add(b3);

        System.out.println("b1.equals(b2)? " + b1.equals(b2));
        System.out.println("Set size: " + library.size());
    }
}