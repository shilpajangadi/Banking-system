package models;
import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private double postBalance;
    private Date date;

    public Transaction(String type, double amount, double postBalance) {
        this.type = type;
        this.amount = amount;
        this.postBalance = postBalance;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return date + " | " + type + " | ₹" + amount + " | Balance: ₹" + postBalance;
    }
}
