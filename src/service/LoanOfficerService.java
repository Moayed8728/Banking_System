package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.AccountHolder;
import model.BankAccount;
import model.Loan;
import model.Transaction;
import util.TransactionIdGenerator;

/**
 * Business logic for loan officer operations.
 */
public class LoanOfficerService {

    public void processLoans(Scanner sc, List<Loan> pendingLoans) {
        if (pendingLoans.isEmpty()) {
            System.out.println("No pending loans.");
            return;
        }

        for (Loan ln : new ArrayList<>(pendingLoans)) {
            System.out.printf(
                "Loan ID: %s, Amount: RM %.2f, Term: %dm, Borrower: %s%n",
                ln.getLoanId(),
                ln.getAmount(),
                ln.getTermMonths(),
                ln.getBorrower().getName()
            );

            System.out.print("Approve (A) / Reject (R)? ");
            String ans = sc.nextLine().trim().toUpperCase();

            if (ans.equals("A")) {
                ln.setStatus("Approved");

                AccountHolder borrower = ln.getBorrower();
                BankAccount account = borrower.getAccount();

                account.setBalance(account.getBalance() + ln.getAmount());

                account.getTransactions().add(
                    new Transaction(
                        TransactionIdGenerator.transactionId(),
                        "Loan Disbursement",
                        ln.getAmount(),
                        "Loan ID: " + ln.getLoanId()
                    )
                );

                System.out.println("Loan approved and amount deposited to borrower's account.");
            } else {
                ln.setStatus("Rejected");
                System.out.println("Loan rejected.");
            }

            pendingLoans.remove(ln);
        }
    }
}
