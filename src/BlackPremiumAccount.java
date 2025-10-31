public class BlackPremiumAccount extends Account {
    /**
     * Construct an account using account number and balance
     *
     * @param String accountNumber
     * @param double balance
     */
    public BlackPremiumAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Withdraw valid given amount from current balance
     *
     * @param double amount
     * @return bool
     */
    public boolean withdraw(double amount) {
        if ((amount - this.balance) < -4000) {
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
        if ((amount + this.balance) < -4000) {
            System.out.println("Invalid amount!");
            return false;
        }

        this.balance += amount;

        return true;
    }
}
