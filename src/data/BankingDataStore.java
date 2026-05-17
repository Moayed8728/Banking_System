package data;

import java.util.ArrayList;
import java.util.List;
import model.AccountHolder;
import model.BankAccount;
import model.BankOfficer;
import model.FinanceOfficer;
import model.Loan;
import model.LoanOfficer;
import model.SystemAdmin;

/**
 * Temporary in-memory storage for users and pending loans.
 *
 * This class works like a simple fake database and can later be replaced
 * by repositories when the project evolves into Spring Boot.
 */
public class BankingDataStore {

    private List<AccountHolder> accountHolders;
    private List<Loan> pendingLoans;
    private BankOfficer bankOfficer;
    private LoanOfficer loanOfficer;
    private FinanceOfficer financeOfficer;
    private SystemAdmin systemAdmin;

    public BankingDataStore() {
        this.accountHolders = new ArrayList<>();
        this.pendingLoans = new ArrayList<>();
        loadDefaultData();
    }

    private void loadDefaultData() {
        AccountHolder defaultAH = new AccountHolder(
            "A24CS",
            "MOAYED",
            "M47",
            "Ma123",
            new BankAccount("ACc1221", 10000)
        );

        AccountHolder defaultAH2 = new AccountHolder(
            "A25CS",
            "AHMED",
            "AH18",
            "Ah123",
            new BankAccount("ACc2112", 5000)
        );

        accountHolders.add(defaultAH);
        accountHolders.add(defaultAH2);

        bankOfficer = new BankOfficer("A24CS0017", "MOAYED", "MOAYED", "off123");
        loanOfficer = new LoanOfficer("A24CS0027", "OMAR", "OMAR", "loan123");
        financeOfficer = new FinanceOfficer("A24CS", "HOSAM", "HOSAM", "fin123");
        systemAdmin = new SystemAdmin("A24CS", "MOHAMED", "MOHAMED", "admin123");
    }

    public List<AccountHolder> getAccountHolders() {
        return accountHolders;
    }

    public List<Loan> getPendingLoans() {
        return pendingLoans;
    }

    public BankOfficer getBankOfficer() {
        return bankOfficer;
    }

    public LoanOfficer getLoanOfficer() {
        return loanOfficer;
    }

    public FinanceOfficer getFinanceOfficer() {
        return financeOfficer;
    }

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }
}
