package main;
import models.*;
import java.util.*;

public class BankingApp {
    private static Bank bank = new Bank();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Create Account | 2. Login | 3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> login();
                case 3 -> { scanner.close(); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Set a password: ");
        String password = scanner.nextLine();

        bank.createAccount(accNum, name, balance, password);
    }

    private static void login() {
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Account userAccount = bank.authenticateUser(accNum, password);
        if (userAccount != null) {
            userDashboard(userAccount);
        }
    }

    private static void userDashboard(Account account) {
        while (true) {
            System.out.println("\n1. View Balance | 2. Deposit | 3. Withdraw | 4. Transaction History | 5. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Balance: ₹" + account.getBalance());
                case 2 -> {
                    System.out.print("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                }
                case 3 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                }
                case 4 -> account.printTransactionHistory();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
