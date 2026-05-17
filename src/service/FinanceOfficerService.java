package service;

import java.util.List;
import java.util.Scanner;
import model.AccountHolder;
import model.Transaction;
import util.TransactionIdGenerator;

/**
 * Business logic for finance officer dividend operations.
 */
public class FinanceOfficerService {

    private static double dividendRate = 0;

    public void setDividendRate(Scanner sc) {
        System.out.print("Enter dividend rate (%) : ");
        dividendRate = sc.nextDouble();
        sc.nextLine();
        System.out.printf("Dividend rate set to %.2f%%%n", dividendRate);
    }

    public void distributeDividends(List<AccountHolder> accountHolders) {
        System.out.println("Distributing dividends...");

        for (AccountHolder ah : accountHolders) {
            double div = ah.getAccount().getBalance() * dividendRate / 100;
            ah.getAccount().setBalance(ah.getAccount().getBalance() + div);
            ah.getAccount().getTransactions().add(
                new Transaction(TransactionIdGenerator.transactionId(), "Dividend", div, "Dividend payout")
            );

            System.out.printf("Paid RM %.2f to %s%n", div, ah.getName());
        }
    }
}
