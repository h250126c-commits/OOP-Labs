package lab11;

// EXPLAIN: an interface is a contract of capabilities that unrelated classes could share
public interface Borrowable {
    void borrow(Member member) throws ItemNotAvailableException, MemberLimitExceededException;
    void giveBack();
}