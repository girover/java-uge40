/**
 * This class represents money box that can keep track of an amount in coins.
 * 
 * @author Majed Girover
 */
public class MoneyBox {

    //
    private int twenties;
    private int tens;
    private int fives;
    private int twos;
    private int ones;

    /**
     * Default constructor
     */
    MoneyBox() {
        set(20, 0);
        set(10, 0);
        set(5, 0);
        set(2, 0);
        set(1, 0);
    }

    /**
     * Copy-Constructor
     * it sets MoneyBox to have the same content of coins as the given as a
     * parameter.
     * 
     * @param moneyBox
     */
    MoneyBox(MoneyBox moneyBox) {
        set(20, moneyBox.get(20));
        set(10, moneyBox.get(10));
        set(5, moneyBox.get(5));
        set(2, moneyBox.get(2));
        set(1, moneyBox.get(1));
    }

    /**
     * Sets the specific coin to have the given count as parameter.
     * 
     * @param coin
     * @param count
     */
    public void set(int coin, int count) {

        if (count < 0) {
            System.out.println("Count must be a positive number\n");
            return;
        }

        switch (coin) {
            case 20:
                twenties = count;
                break;
            case 10:
                tens = count;
                break;
            case 5:
                fives = count;
                break;
            case 2:
                twos = count;
                break;
            case 1:
                ones = count;
                break;

            default:
                System.out.println("coin is not valid");
                break;
        }
    }

    /**
     * Returns the count of the given coin as parameter.
     * 
     * @param coin
     * @return int
     */
    public int get(int coin) {
        switch (coin) {
            case 20:
                return twenties;
            case 10:
                return tens;
            case 5:
                return fives;
            case 2:
                return twos;
            case 1:
                return ones;

            default:
                System.out.println("Wrong provided coin");
                return 0;
        }
    }

    /**
     * Returns the amount of the coin that is given as parameter.
     * 
     * @param coin
     * @return int
     */
    public int amountOf(int coin) {
        switch (coin) {
            case 20:
                return get(20) * 20;
            case 10:
                return get(10) * 10;
            case 5:
                return get(5) * 5;
            case 2:
                return get(2) * 2;
            case 1:
                return get(1);

            default:
                System.out.println("Wrong provided coin");
                return 0;
        }
    }

    /**
     * Increment the given coin by 1 if possible.
     * 
     * @param coin
     */
    private void increment(int coin) {
        set(coin, get(coin)+1);
    }

    /**
     * Decrement the given coin by 1 if possible.
     * 
     * @param coin
     */
    private void decrement(int coin) {
        if (get(coin)>0) {
            set(coin, get(coin)-1);
        }
    }

    /**
     * Returns the whole amount in the money box.
     * 
     * @return int
     */
    public int sum() {
        return get(20) * 20 + get(10) * 10 + get(5) * 5 + get(2) * 2 + get(1);
    }

    /**
     * Returns the coins quantity in the money box.
     * 
     * @return int
     */
    public int totalQuantity() {
        return get(20) + get(10) + get(5) + get(2) + get(1);
    }

    /**
     * Checks if the money box has the same amount of coins as the given money box
     * as parameter.
     * 
     * @param moneyBox
     * @return boolean
     */
    public boolean equals(MoneyBox moneyBox) {
        return get(20) == moneyBox.get(20) &&
                get(10) == moneyBox.get(10) &&
                get(5) == moneyBox.get(5) &&
                get(2) == moneyBox.get(2) &&
                get(1) == moneyBox.get(1)
                        ? true
                        : false;
    }

    /**
     * Takes coins from the money box that is given as parameter.
     * 
     * @param moneyBox
     */
    public void add(MoneyBox moneyBox) {

        set(20, get(20) + moneyBox.get(20));
        set(10, get(10) + moneyBox.get(10));
        set(5, get(5) + moneyBox.get(5));
        set(2, get(2) + moneyBox.get(2));
        set(1, get(1) + moneyBox.get(1));

        moneyBox.empty();
    }

    /**
     * Takes an amount and then returns an object of MoneyBox
     * containing the amount converted to different coins.
     * 
     * @param amount
     * @return MoneyBox
     */
    public MoneyBox getMoneyBox(int amount) {

        MoneyBox moneyBox = new MoneyBox();

        while (amount >= 20 && get(20) > 0) {
            moneyBox.increment(20);
            decrement(20);
            amount -= 20;
        }

        while (amount >= 10 && get(10) > 0) {
            moneyBox.increment(10);
            decrement(10);
            amount -= 10;
        }

        while (amount >= 5 && get(5) > 0) {
            moneyBox.increment(5);
            decrement(5);
            amount -= 5;
        }

        while (amount >= 2 && get(2) > 0) {
            moneyBox.increment(2);
            decrement(2);
            amount -= 2;
        }

        if (amount > get(1)) {
            add(moneyBox);
            return null;
        } else {
            moneyBox.set(1, amount);
            set(1, get(1) - amount);
            return moneyBox;
        }
    }

    /**
     * Empties the money box from all coins.
     * Sets all variables to 0
     */
    public void empty() {
        set(20, 0);
        set(10, 0);
        set(5, 0);
        set(2, 0);
        set(1, 0);
    }

    /**
     * Get the all coins in the money box as string.
     * 
     * @return String
     */
    public String toString() {
        String s = String.format("\u001B[34m%-10s  %8s \u001B[0m%n", "", "Money Box");
        s += String.format("-".repeat(35) + "%n");
        s += String.format("\u001B[31m%-15s  %8s %8s \u001B[0m%n", "Coin", "Quantity", "amount");
        s += String.format("-".repeat(35) + "%n");
        s += String.format("%-15s  %7d %7d %n", "Twenties", get(20), amountOf(20));
        s += String.format("-".repeat(35) + "%n");
        s += String.format("%-15s  %7d %7d %n", "Tens", get(10), amountOf(10));
        s += String.format("-".repeat(35) + "%n");
        s += String.format("%-15s  %7d %7d %n", "Fives", get(5), amountOf(5));
        s += String.format("-".repeat(35) + "%n");
        s += String.format("%-15s  %7d %7d %n", "tows", get(2), amountOf(2));
        s += String.format("-".repeat(35) + "%n");
        s += String.format("%-15s  %7d %7d %n", "ones", get(1), amountOf(1));
        s += String.format("-".repeat(35) + "%n");
        s += String.format("\u001B[32m%-15s  %7d %7d \u001B[0m%n", "Total", totalQuantity(), sum());
        s += String.format("-".repeat(35) + "%n");

        return s;
    }
}
