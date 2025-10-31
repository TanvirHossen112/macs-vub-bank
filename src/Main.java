void main() {
    Bank bank = new Bank();

    bank.addClient(1001, 1234);
    bank.addClient(1002, 5678);
    bank.addClient(1003, 9999);
    System.out.println();

    bank.addClient(1001, 1234);
    System.out.println();

    bank.login(1001, 1234);
    System.out.println();

    bank.login(1001, 9999);
    System.out.println();
    bank.login(9999, 1234);
    System.out.println();
    bank.login(1001, 1234);
    bank.addAccount(new GreenStandardAccount("ACC-1001-01", 10000));
    bank.addAccount(new BlackPremiumAccount("ACC-1001-02", 4000));
    bank.addAccount(new GoldUnlimitedAccount("ACC-1001-03", 0));
    System.out.println();
    bank.showAccounts();
    System.out.println();
}
