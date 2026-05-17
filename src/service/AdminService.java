package service;

import java.util.List;
import java.util.Scanner;
import model.AccountHolder;

/**
 * Business logic for system administrator operations.
 */
public class AdminService {

    public void generateReport(List<AccountHolder> accountHolders) {
        System.out.println("\n--- Daily Report ---");

        for (AccountHolder ah : accountHolders) {
            System.out.printf(
                "ID: %s, Name: %s, Acc#: %s, Balance: RM %.2f%n",
                ah.getId(),
                ah.getName(),
                ah.getAccount().getAccountNumber(),
                ah.getAccount().getBalance()
            );
        }
    }

    public void resetUserPassword(Scanner sc, List<AccountHolder> accountHolders) {
        System.out.print("Enter account username: ");
        String uname = sc.nextLine();

        for (AccountHolder ah : accountHolders) {
            if (ah.getUsername().equals(uname)) {
                System.out.print("Enter new password: ");
                ah.setPassword(sc.nextLine());
                System.out.println("Password updated for " + ah.getName());
                return;
            }
        }

        System.out.println("Account not found.");
    }
}
