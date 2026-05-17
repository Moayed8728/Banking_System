package model;

/**
 * Represents a loan application for an account holder.
 */
public class Loan {

    private String loanId;
    private double amount;
    private int termMonths;
    private String status;
    private AccountHolder borrower;

    public Loan(String loanId, double amount, int termMonths, String status, AccountHolder borrower) {
        this.loanId = loanId;
        this.amount = amount;
        this.termMonths = termMonths;
        this.status = status;
        this.borrower = borrower;
    }

    public String getLoanId() {
        return loanId;
    }

    public double getAmount() {
        return amount;
    }

    public int getTermMonths() {
        return termMonths;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AccountHolder getBorrower() {
        return borrower;
    }
}
