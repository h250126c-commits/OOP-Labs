package lab06;

abstract class Account {
    private final String accountNumber;
    private double balance;

    Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    // concrete method: identical for every account type
    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        balance += amount;
    }

    // abstract method: each account type charges differently
    abstract double monthlyFee();

    // concrete method that relies on the abstract one
    void applyMonthlyFee() {
        balance -= monthlyFee();
    }

    String getAccountNumber() { return accountNumber; }
    double getBalance()       { return balance; }
}

class SavingsAccount extends Account {
    SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    // no fee if the balance is 1000 or more, otherwise 5.00
    @Override
    double monthlyFee() {
        return getBalance() >= 1000 ? 0 : 5.00;
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    // flat fee
    @Override
    double monthlyFee() {
        return 15.00;
    }
}

public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("SAV-001", 500),
            new CurrentAccount("CUR-001", 300)
        };

        for (Account a : accounts) {
            a.deposit(200);
            double fee = a.monthlyFee();
            a.applyMonthlyFee();
            System.out.printf("%s: fee %.2f, balance %.2f%n",
                    a.getAccountNumber(), fee, a.getBalance());
        }

        accounts[0].deposit(-50);   // invalid amount
    }
}
