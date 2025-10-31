import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private Client loggedInClient;
    private Map<Client, List<Account>> clientAccountMap = new HashMap<>();

    /**
     * Authenticate a client using ID and PIN
     *
     * @param int id
     * @param int pin
     * @return bool
     */
    public boolean login(int id, int pin) {
        if (clientAccountMap.isEmpty()) {
            System.out.println("Client account list is empty!");
        }

        for (Client client : clientAccountMap.keySet()) {
            if (client.getID() == id && client.pinMatch(pin)) {
                if (this.loggedInClient != null) {
                    this.logout();
                }
                this.loggedInClient = client;
                System.out.println("Successfully logged in!");
                System.out.println("ID: " + loggedInClient.getID());
                return true;
            }
        }

        System.out.println("Unauthorized!");
        return false;
    }

    /**
     * Logout currently logged in a client
     *
     * @return bool
     */
    public boolean logout() {
        if (this.loggedInClient != null) {
            this.loggedInClient = null;
            System.out.println("Successfully logged out!");
            return true;
        }

        System.out.println("Unauthorized!");
        return false;
    }

    /**
     * Add a new account for a logged-in client
     *
     * @param Account account
     * @return bool
     */
    public boolean addAccount(Account account) {
        if (this.loggedInClient == null) {
            System.out.println("Unauthorized!");
            return false;
        }

        List<Account> accountList = clientAccountMap.get(this.loggedInClient);
        accountList.add(account);
        System.out.println("Successfully added account!");
        System.out.println("Client ID: " + this.loggedInClient.getID());
        System.out.println("Account No: " + account.getAccountNumber());

        return true;
    }

    /**
     * Remove an account from a logged-in client
     *
     * @param String accountNumber
     * @return bool
     */
    public boolean removeAccount(String accountNumber) {
        if (this.loggedInClient == null) {
            System.out.println("Unauthorized!");
            return false;
        }

        List<Account> accounts = clientAccountMap.get(this.loggedInClient);
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accounts.remove(account);
                System.out.println("Successfully removed account!");
                return true;
            }
        }

        System.out.println("Invalid operation!");
        return false;
    }

    /**
     * Add a new client to the bank
     *
     * @param int clientID
     * @param int pin
     * @return bool
     */
    public boolean addClient(int clientID, int pin) {
        Client client = new Client(clientID, pin);

        if (!clientAccountMap.isEmpty()) {
            for (Client c : clientAccountMap.keySet()) {
                if (c.getID() == clientID) {
                    System.out.println("Client(" + clientID + ") already exists!");
                    return false;
                }
            }
        }

        this.clientAccountMap.put(client, new ArrayList<Account>());
        System.out.println("Successfully added Client!");
        System.out.println("Client ID: " + clientID);

        return true;
    }

    /**
     * Remove an existing client from the bank
     *
     * @param int clientID
     * @return bool
     */
    public boolean removeClient(int clientID) {
        if (this.clientAccountMap.isEmpty()) {
            System.out.println("Client list is empty!");
            return false;
        }

        for (Client client : this.clientAccountMap.keySet()) {
            if (client.getID() == clientID) {
                this.clientAccountMap.remove(client);
                System.out.println("Successfully removed client(" + clientID + ")");
                return true;
            }
        }

        System.out.println("Invalid operation!");
        return false;
    }

    /**
     * Display all accounts of a logged-in client
     */
    public void showAccounts() {
        if (this.loggedInClient == null) {
            System.out.println("Unauthorized!");
            return;
        }

        System.out.println("Client Accounts:");
        int i = 1;
        List<Account> accounts = this.clientAccountMap.get(this.loggedInClient);
        for (Account account : accounts) {
            System.out.println("**********************************************");
            account.getOverview();
            System.out.println("**********************************************");
        }
    }

    /**
     * Transfer amount between two accounts of a logged-in client
     *
     * @param Account sourceAccount
     * @param Account destinationAccount
     * @param double  amount
     * @return bool
     */
    public boolean transfer(Account sourceAccount, Account destinationAccount, double amount) {
        if (this.loggedInClient == null) {
            System.out.println("Unauthorized!");
            return false;
        }

        if (sourceAccount == null || destinationAccount == null) {
            System.out.println("Invalid accounts!");
            return false;
        }

        List<Account> accounts = this.clientAccountMap.get(this.loggedInClient);
        boolean sourceAccountFound = false;
        boolean destinationAccountFound = false;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(sourceAccount.getAccountNumber())) {
                sourceAccountFound = true;
            }
            if (account.getAccountNumber().equals(destinationAccount.getAccountNumber())) {
                destinationAccountFound = true;
            }
        }
        if (!sourceAccountFound || !destinationAccountFound) {
            System.out.println("Invalid Operation!");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return false;
        }

        if (!sourceAccount.withdraw(amount)) {
            return false;
        }

        if (!destinationAccount.deposit(amount)) {
            sourceAccount.deposit(amount);
            return false;
        }

        System.out.println("Transaction successful!");
        System.out.println("Source Account No: " + sourceAccount.getAccountNumber());
        System.out.println("Destination Account No: " + destinationAccount.getAccountNumber());
        System.out.println("Amount: " + amount);

        return true;
    }
}
