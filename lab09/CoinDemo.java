package lab09;

enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private final int value;

    Coin(int value) { this.value = value; }

    int getValue() { return value; }

    // EXPLAIN: greedy method; start from the biggest coin and work down
    static void makeChange(int amount) {
        Coin[] coins = Coin.values();
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int n = amount / coins[i].value;
            if (n > 0) {
                System.out.println(n + " x " + coins[i]);
                count += n;
                amount -= n * coins[i].value;
            }
        }
        System.out.println("Total coins: " + count);
    }
}

public class CoinDemo {
    public static void main(String[] args) {
        System.out.println("Change for 68:");
        Coin.makeChange(68);
    }
}