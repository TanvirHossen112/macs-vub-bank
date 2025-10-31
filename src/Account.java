public abstract class Account {

    protected double balance;
    protected String accountNumber;

    /**
     * Construct an account using account number and balance
     *
     * @param String accountNumber
     * @param double balance
     */
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Getter for account number
     *
     * @return String
     */
    public String getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Display details like account number and balance
     */
    public void getOverview() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Balance: " + this.balance);
    }

    /**
     * Withdraw valid given amount from current balance
     *
     * @param double amount
     * @return bool
     */
    public abstract boolean withdraw(double amount);

    /**
     * Deposit given amount with current balance
     *
     * @param double amount
     * @return bool
     */
    public abstract boolean deposit(double amount);
}
