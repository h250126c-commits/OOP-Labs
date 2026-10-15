package lab07;

// checked exception that carries how much was missing
class InsufficientFundsException extends Exception {
    private final double shortfall;

    InsufficientFundsException(String message, double shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    double getShortfall() { return shortfall; }
}

class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;

    BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName.trim();
        this.balance = openingBalance;
    }

    String getAccountNumber() { return accountNumber; }
    String getOwnerName()     { return ownerName; }
    double getBalance()       { return balance; }

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    // was: boolean withdraw(double amount) returning false on failure
    // now: void, and throws a checked exception on failure
    void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Cannot withdraw " + amount + "; balance is " + balance,
                amount - balance);
        }
        balance -= amount;
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500.00);

        try {
            acc.withdraw(200);
            System.out.println("Withdrew 200.0, balance now " + acc.getBalance());

            acc.withdraw(400);      // fails
            System.out.println("never printed");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Short by: " + e.getShortfall());
        }

        System.out.println("Final balance: " + acc.getBalance());
    }
}