package models;
import java.util.*;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String accNumber, String holder, double initialBalance, String password) {
        if (accounts.containsKey(accNumber)) {
            System.out.println("Account already exists!");
        } else {
            accounts.put(accNumber, new Account(accNumber, holder, initialBalance, password));
            System.out.println("Account created successfully!");
        }
    }

    public Account authenticateUser(String accNumber, String password) {
        Account acc = accounts.get(accNumber);
        if (acc != null && acc.authenticate(password)) {
            return acc;
        }
        System.out.println("Invalid account number or password.");
        return null;
    }

    public void showAllAccounts() {
        System.out.println("\nBank Accounts:");
        for (Account acc : accounts.values()) {
            System.out.println(acc.getAccountNumber() + " | " + acc.getAccountHolder() + " | ₹" + acc.getBalance());
        }
    }
}
