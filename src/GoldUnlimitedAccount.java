public class GoldUnlimitedAccount extends Account {

    /**
     * Construct an account using account number and balance
     *
     * @param String accountNumber
     * @param double balance
     */
    public GoldUnlimitedAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Withdraw valid given amount from current balance
     *
     * @param double amount
     * @return bool
     */
    public boolean withdraw(double amount) {
        if (Double.isNaN(amount)) {
            System.out.println("Invalid amount!");
            return false;
        }

        this.balance -= amount;

        return true;
    }

    /**
     * Deposit given amount with current balance
     *
     * @param double amount
     * @return bool
     */
    public boolean deposit(double amount) {
        if (Double.isNaN(amount)) {
            System.out.println("Invalid amount!");
            return false;
        }

        this.balance += amount;

        return true;
    }
}
