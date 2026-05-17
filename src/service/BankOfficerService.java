package service;

import java.util.List;
import java.util.Scanner;
import model.AccountHolder;
import model.BankAccount;

/**
 * Business logic for bank officer operations.
 */
public class BankOfficerService {

    public void registerNewAccount(Scanner sc, List<AccountHolder> accountHolders) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter full name: ");
        String name = sc.nextLine();
        System.out.print("Enter username: ");
        String uname = sc.nextLine();
        System.out.print("Enter password: ");
        String pwd = sc.nextLine();
        System.out.print("Enter initial deposit: ");
        double depo = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();

        BankAccount ba = new BankAccount(accNum, depo);
        AccountHolder ah = new AccountHolder(id, name, uname, pwd, ba);
        accountHolders.add(ah);

        System.out.println("Account created for " + name);
    }

    public void viewAccountDetails(Scanner sc, List<AccountHolder> accountHolders) {
        System.out.print("Enter account username: ");
        String uname = sc.nextLine();

        for (AccountHolder ah : accountHolders) {
            if (ah.getUsername().equals(uname)) {
                System.out.println("ID: " + ah.getId());
                System.out.println("Name: " + ah.getName());
                System.out.println("Account #: " + ah.getAccount().getAccountNumber());
                System.out.printf("Balance : RM %.2f%n", ah.getAccount().getBalance());
                return;
            }
        }

        System.out.println("Account not found.");
    }
}
