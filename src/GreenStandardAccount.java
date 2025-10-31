public class GreenStandardAccount extends Account {

    /**
     * Construct an account using account number and balance
     *
     * @param String accountNumber
     * @param double balance
     */
    public GreenStandardAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Withdraw valid given amount from current balance
     *
     * @param double amount
     * @return bool
     */
    public boolean withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount!");
            return false;
        }

        if (amount > this.balance) {
            System.out.println("Insufficient Balance!");
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
        if (amount < 0) {
            System.out.println("Invalid amount!");
            return false;
        }

        this.balance += amount;

        return true;
    }
}
