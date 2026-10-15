package lab11;

public class MemberLimitExceededException extends Exception {
    public MemberLimitExceededException(String message) {
        super(message);
    }
}