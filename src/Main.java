/*   MOAYED MOHAMEd   || A24CS0017
                 
*/

import data.BankingDataStore;
import java.util.Scanner;
import model.AccountHolder;
import service.AccountHolderService;
import service.AdminService;
import service.AuthService;
import service.BankOfficerService;
import service.FinanceOfficerService;
import service.LoanOfficerService;

/**
 * Console entry point for the Banking System.
 *
 * Main is responsible for starting the application, showing menus,
 * handling navigation, and calling service classes.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingDataStore dataStore = new BankingDataStore();

        AccountHolderService accountHolderService = new AccountHolderService();
        BankOfficerService bankOfficerService = new BankOfficerService();
        LoanOfficerService loanOfficerService = new LoanOfficerService();
        FinanceOfficerService financeOfficerService = new FinanceOfficerService();
        AdminService adminService = new AdminService();
        AuthService authService = new AuthService();

        boolean running = true;

        while (running) {
            displayMainMenu();
            int role = sc.nextInt();
            sc.nextLine();

            switch (role) {
                case 1:
                    System.out.print("Username: ");
                    String u1 = sc.nextLine();
                    System.out.print("Password: ");
                    String p1 = sc.nextLine();

                    AccountHolder current = authService.loginAccountHolder(
                        u1,
                        p1,
                        dataStore.getAccountHolders()
                    );

                    if (current == null) {
                        System.out.println("Login failed.");
                        break;
                    }

                    boolean ahMenu = true;
                    while (ahMenu) {
                        displayAccountHolderMenu();
                        int c = sc.nextInt();
                        sc.nextLine();

                        switch (c) {
                            case 1:
                                accountHolderService.viewAccountDetails(current);
                                break;

                            case 2:
                                accountHolderService.depositMoney(current, sc);
                                break;

                            case 3:
                                accountHolderService.withdrawMoney(current, sc);
                                break;

                            case 4:
                                accountHolderService.transferMoney(
                                    current,
                                    sc,
                                    dataStore.getAccountHolders()
                                );
                                break;

                            case 5:
                                accountHolderService.viewTransactionHistory(current);
                                break;

                            case 6:
                                accountHolderService.applyForLoan(
                                    current,
                                    sc,
                                    dataStore.getPendingLoans()
                                );
                                break;

                            case 7:
                                accountHolderService.viewLoanStatus(current);
                                break;

                            case 8:
                                accountHolderService.createTabung(current, sc);
                                break;

                            case 9:
                                accountHolderService.allocateMoneyTabung(current, sc);
                                break;

                            case 10:
                                accountHolderService.withdrawFromTabung(current, sc);
                                break;

                            case 11:
                                accountHolderService.viewTabungStatus(current);
                                break;

                            case 12:
                                ahMenu = false;
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case 2:
                    displayBankOfficerMenu();
                    int boC = sc.nextInt();
                    sc.nextLine();
                    if (boC == 1) {
                        bankOfficerService.registerNewAccount(sc, dataStore.getAccountHolders());
                    } else if (boC == 2) {
                        bankOfficerService.viewAccountDetails(sc, dataStore.getAccountHolders());
                    }
                    break;

                case 3:
                    displayLoanOfficerMenu();
                    int loC = sc.nextInt();
                    sc.nextLine();
                    if (loC == 1) {
                        loanOfficerService.processLoans(sc, dataStore.getPendingLoans());
                    }
                    break;

                case 4:
                    displayFinanceOfficerMenu();
                    int foC = sc.nextInt();
                    sc.nextLine();
                    if (foC == 1) {
                        financeOfficerService.setDividendRate(sc);
                    } else if (foC == 2) {
                        financeOfficerService.distributeDividends(dataStore.getAccountHolders());
                    }
                    break;

                case 5:
                    displaySystemAdminMenu();
                    int saC = sc.nextInt();
                    sc.nextLine();
                    if (saC == 1) {
                        adminService.generateReport(dataStore.getAccountHolders());
                    } else if (saC == 2) {
                        adminService.resetUserPassword(sc, dataStore.getAccountHolders());
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Thanks For visiting our system. Ciao!!!!");
                    break;

                default:
                    System.out.println("Invalid role. Choose from 1-6 please");
            }
        }

        sc.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n=== Welcome to Banking System ===");
        System.out.println("1. Account Holder");
        System.out.println("2. Bank Officer");
        System.out.println("3. Loan Officer");
        System.out.println("4. Finance Officer");
        System.out.println("5. System Admin");
        System.out.println("6. Exit");
        System.out.print("Select role: ");
    }

    private static void displayAccountHolderMenu() {
        System.out.println("\n---- Account Holder Menu ----");
        System.out.println("1. View Account Details");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. View Transaction History");
        System.out.println("6. Apply for Loan");
        System.out.println("7. View Loan Status");
        System.out.println("8. Create Tabung");
        System.out.println("9. Allocate Money Into Tabung");
        System.out.println("10. Withdraw From Tabung");
        System.out.println("11. View Tabung Status");
        System.out.println("12. Logout");
        System.out.print("Enter choice: ");
    }

    private static void displayBankOfficerMenu() {
        System.out.println("\n---- Bank Officer Menu ----");
        System.out.println("1. Register New Account");
        System.out.println("2. View Account Details");
        System.out.println("3. Logout");
        System.out.print("Enter choice: ");
    }

    private static void displayLoanOfficerMenu() {
        System.out.println("\n---- Loan Officer Menu ----");
        System.out.println("1. Approve/Reject Loans");
        System.out.println("2. Logout");
        System.out.print("Enter choice: ");
    }

    private static void displayFinanceOfficerMenu() {
        System.out.println("\n---- Finance Officer Menu ----");
        System.out.println("1. Set Dividend Rate");
        System.out.println("2. Distribute Dividends");
        System.out.println("3. Logout");
        System.out.print("Enter choice: ");
    }

    private static void displaySystemAdminMenu() {
        System.out.println("\n---- System Admin Menu ----");
        System.out.println("1. Generate Daily Report");
        System.out.println("2. Reset User Password");
        System.out.println("3. Logout");
        System.out.print("Enter choice: ");
    }
}
