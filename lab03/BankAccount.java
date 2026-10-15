package lab03;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
        history.add("Opened with " + openingBalance);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
        history.add("Deposited " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) {
            history.add("Failed withdrawal of " + amount);
            return false;
        }
        balance -= amount;
        history.add("Withdrew " + amount);
        return true;
    }

    // EXPLAIN: List.copyOf returns an unmodifiable COPY, so callers cannot change our real history
    public List<String> getHistory() {
        return List.copyOf(history);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500);
        acc.deposit(250);
        acc.withdraw(100);
        acc.withdraw(5000);

        for (String line : acc.getHistory()) {
            System.out.println(line);
        }

        try {
            acc.getHistory().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("History cannot be modified from outside");
        }
        System.out.println("Final balance: " + acc.getBalance());
    }
}