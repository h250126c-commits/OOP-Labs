package lab11;

// EXPLAIN: extends Exception, so it is a CHECKED exception callers must handle
public class ItemNotAvailableException extends Exception {
    public ItemNotAvailableException(String message) {
        super(message);
    }
}