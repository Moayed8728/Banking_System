package model;

/**
 * Loan officer user who can approve or reject loan applications.
 */
public class LoanOfficer extends User {

    public LoanOfficer(String id, String name, String username, String password) {
        super(id, name, username, password);
    }
}
