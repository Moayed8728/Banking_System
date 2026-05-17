package service;

import java.util.List;
import java.util.Scanner;
import model.AccountHolder;
import model.BankAccount;
import model.Loan;
import model.SavingsGoal;
import model.Transaction;
import util.TransactionIdGenerator;

/**
 * Business logic for account holder banking operations.
 */
public class AccountHolderService {

    public void viewAccountDetails(AccountHolder accountHolder) {
        System.out.println("\nAccount Number: " + accountHolder.getAccount().getAccountNumber());
        System.out.printf("Balance       : RM %.2f%n", accountHolder.getAccount().getBalance());
    }

    public void depositMoney(AccountHolder accountHolder, Scanner sc) {
        depositMoney(accountHolder, sc, "Cash deposit");
    }

    public void depositMoney(AccountHolder accountHolder, Scanner sc, String note) {
        System.out.print("Enter amount to deposit: ");

        double amt = sc.nextDouble();
        sc.nextLine();

        if (amt <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        BankAccount account = accountHolder.getAccount();
        account.setBalance(account.getBalance() + amt);

        accountHolder.getTransactions().add(
            new Transaction(TransactionIdGenerator.transactionId(), "Deposit", amt, note)
        );

        System.out.printf("Deposit successful. New balance: RM %.2f%n", account.getBalance());
    }

    public void depositFromLoan(AccountHolder accountHolder, double amount, String loanId) {
        System.out.println("DEBUG: depositFromLoan called with amount = " + amount);
        if (amount > 0) {
            BankAccount account = accountHolder.getAccount();
            account.setBalance(account.getBalance() + amount);
            accountHolder.getTransactions().add(
                new Transaction(
                    TransactionIdGenerator.transactionId(),
                    "Loan Disbursement",
                    amount,
                    "Loan ID: " + loanId
                )
            );
        }
    }

    public void withdrawMoney(AccountHolder accountHolder, Scanner sc) {
        System.out.print("Enter amount to withdraw: ");

        double amt = sc.nextDouble();
        sc.nextLine();

        BankAccount account = accountHolder.getAccount();
        if (amt <= 0 || amt > account.getBalance()) {
            System.out.println("Invalid amount or insufficient balance.");
            return;
        }

        account.setBalance(account.getBalance() - amt);

        accountHolder.getTransactions().add(
            new Transaction(TransactionIdGenerator.transactionId(), "Withdrawal", amt, "Cash withdrawal")
        );

        System.out.printf("Withdrawal successful. New balance: RM %.2f%n", account.getBalance());
    }

    public void transferMoney(AccountHolder accountHolder, Scanner sc, List<AccountHolder> allUsers) {
        System.out.print("Enter target account number: ");

        String targetAcc = sc.nextLine();
        AccountHolder targetUser = null;

        for (AccountHolder ah : allUsers) {
            if (ah.getAccount().getAccountNumber().equals(targetAcc)) {
                targetUser = ah;
                break;
            }
        }

        if (targetUser == null) {
            System.out.println("Target account not found.");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        BankAccount sender = accountHolder.getAccount();
        if (amt <= 0 || amt > sender.getBalance()) {
            System.out.println("Invalid amount or insufficient balance.");
            return;
        }

        BankAccount receiver = targetUser.getAccount();
        sender.setBalance(sender.getBalance() - amt);
        receiver.setBalance(receiver.getBalance() + amt);

        Transaction outTx = new Transaction(
            TransactionIdGenerator.transactionId(),
            "Transfer Out",
            amt,
            "To " + receiver.getAccountNumber()
        );
        Transaction inTx = new Transaction(
            TransactionIdGenerator.transactionIdPlusOne(),
            "Transfer In",
            amt,
            "From " + sender.getAccountNumber()
        );

        sender.getTransactions().add(outTx);
        receiver.getTransactions().add(inTx);

        System.out.println("Transfer successful. New balance: RM " + sender.getBalance());
    }

    public void viewTransactionHistory(AccountHolder accountHolder) {
        if (accountHolder.getTransactions().isEmpty()) {
            System.out.println("No transactions.");
            return;
        }

        for (Transaction t : accountHolder.getTransactions()) {
            System.out.println(t);
        }
    }

    public void applyForLoan(AccountHolder accountHolder, Scanner sc, List<Loan> pendingLoans) {
        if (accountHolder.getLoan() != null && accountHolder.getLoan().getStatus().equals("Pending")) {
            System.out.println("You already have a pending loan.");
            return;
        }

        System.out.print("Enter loan amount: ");
        double amt = sc.nextDouble();

        System.out.print("Enter term in months: ");
        int term = sc.nextInt();
        sc.nextLine();

        String loanId = TransactionIdGenerator.loanId();
        Loan newLoan = new Loan(loanId, amt, term, "Pending", accountHolder);

        pendingLoans.add(newLoan);
        accountHolder.setLoan(newLoan);

        System.out.println("Loan application submitted. ID: " + loanId);
    }

    public void viewLoanStatus(AccountHolder accountHolder) {
        if (accountHolder.getLoan() == null) {
            System.out.println("No loan applications.");
        } else {
            System.out.println("Loan ID     : " + accountHolder.getLoan().getLoanId());
            System.out.printf("Amount      : RM %.2f%n", accountHolder.getLoan().getAmount());
            System.out.println("Term (mths) : " + accountHolder.getLoan().getTermMonths());
            System.out.println("Status      : " + accountHolder.getLoan().getStatus());
        }
    }

    public void createTabung(AccountHolder accountHolder, Scanner sc) {
        System.out.print("Enter name for Tabung: ");
        String name = sc.nextLine();
        System.out.print("Enter target amount: ");
        double target = sc.nextDouble();
        sc.nextLine();

        SavingsGoal tb = new SavingsGoal(name, target);
        accountHolder.getSavingsGoals().add(tb);

        System.out.printf("Tabung '%s' created with target RM %.2f%n", name, target);
    }

    public void allocateMoneyTabung(AccountHolder accountHolder, Scanner sc) {
        if (accountHolder.getSavingsGoals().isEmpty()) {
            System.out.println("No Tabung found.");
            return;
        }

        System.out.println("Select Tabung to allocate:");
        for (int i = 0; i < accountHolder.getSavingsGoals().size(); i++) {
            SavingsGoal t = accountHolder.getSavingsGoals().get(i);
            System.out.printf("%d. %s (%.2f/%.2f)%n", i + 1, t.getName(), t.getCurrentAmount(), t.getTargetAmount());
        }

        int idx = sc.nextInt();
        sc.nextLine();

        if (idx < 1 || idx > accountHolder.getSavingsGoals().size()) {
            System.out.println("Invalid choice.");
            return;
        }

        SavingsGoal sel = accountHolder.getSavingsGoals().get(idx - 1);

        System.out.print("Enter amount to allocate: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        BankAccount account = accountHolder.getAccount();
        if (amt <= 0 || amt > account.getBalance()) {
            System.out.println("Invalid amount or insufficient balance.");
            return;
        }

        account.setBalance(account.getBalance() - amt);
        sel.deposit(amt);
        accountHolder.getTransactions().add(
            new Transaction(TransactionIdGenerator.transactionId(), "Tabung Allocation", amt, sel.getName())
        );
        System.out.printf("Allocated RM %.2f to '%s'.%n", amt, sel.getName());
    }

    public void withdrawFromTabung(AccountHolder accountHolder, Scanner sc) {
        if (accountHolder.getSavingsGoals().isEmpty()) {
            System.out.println("No Tabung found.");
            return;
        }

        System.out.println("Select Tabung to withdraw from:");
        for (int i = 0; i < accountHolder.getSavingsGoals().size(); i++) {
            SavingsGoal t = accountHolder.getSavingsGoals().get(i);
            System.out.printf("%d. %s (%.2f/%.2f)%n", i + 1, t.getName(), t.getCurrentAmount(), t.getTargetAmount());
        }

        int idx = sc.nextInt();
        sc.nextLine();

        if (idx < 1 || idx > accountHolder.getSavingsGoals().size()) {
            System.out.println("Invalid choice.");
            return;
        }

        SavingsGoal sel = accountHolder.getSavingsGoals().get(idx - 1);

        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        if (amt <= 0 || amt > sel.getCurrentAmount()) {
            System.out.println("Invalid amount.");
            return;
        }

        sel.withdraw(amt);
        accountHolder.getAccount().setBalance(accountHolder.getAccount().getBalance() + amt);
        accountHolder.getTransactions().add(
            new Transaction(TransactionIdGenerator.transactionId(), "Tabung Withdrawal", amt, sel.getName())
        );
        System.out.printf("Withdrawn RM %.2f from '%s'.%n", amt, sel.getName());
    }

    public void viewTabungStatus(AccountHolder accountHolder) {
        if (accountHolder.getSavingsGoals().isEmpty()) {
            System.out.println("No Tabung found.");
            return;
        }

        for (SavingsGoal t : accountHolder.getSavingsGoals()) {
            System.out.printf(
                "%s: %.2f/%.2f (%.1f%%)%n",
                t.getName(),
                t.getCurrentAmount(),
                t.getTargetAmount(),
                t.progressPercent()
            );
        }
    }
}
