package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with a balance and transaction history.
 */
public class BankAccount {

    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
