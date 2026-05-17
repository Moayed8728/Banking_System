package model;

import java.util.Date;

/**
 * Stores one banking transaction record.
 */
public class Transaction {

    private String transactionId;
    private String type;
    private double amount;
    private String note;
    private Date timestamp;

    public Transaction(String transactionId, String type, double amount, String note) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.note = note;
        this.timestamp = new Date();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getNote() {
        return note;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void printDetails() {
        System.out.println("========== Transaction ==========");
        System.out.println("ID    : " + transactionId);
        System.out.println("Type  : " + type);
        System.out.println(String.format("Amount: RM %.2f", amount));
        System.out.println("Note  : " + note);
        System.out.println("Date  : " + timestamp);
        System.out.println("==================================");
    }

    @Override
    public String toString() {
        return transactionId + ": " + type + " RM " + amount;
    }
}
