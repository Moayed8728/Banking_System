package model;

import java.util.ArrayList;
import java.util.List;

/**
 * User who owns a bank account, transactions, Tabung goals, and loan details.
 */
public class AccountHolder extends User {

    private BankAccount account;
    private List<SavingsGoal> savingsGoals;
    private List<Transaction> transactions;
    private Loan loan;

    public AccountHolder(String id, String name, String username, String password, BankAccount account) {
        super(id, name, username, password);
        this.account = account;
        this.savingsGoals = new ArrayList<>();
        this.transactions = account.getTransactions();
        this.loan = null;
    }

    public BankAccount getAccount() {
        return account;
    }

    public List<SavingsGoal> getSavingsGoals() {
        return savingsGoals;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
