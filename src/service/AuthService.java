package service;

import java.util.List;
import model.AccountHolder;

/**
 * Handles simple console login checks.
 */
public class AuthService {

    public AccountHolder loginAccountHolder(String username, String password, List<AccountHolder> accountHolders) {
        for (AccountHolder ah : accountHolders) {
            if (ah.getUsername().equals(username) && ah.getPassword().equals(password)) {
                return ah;
            }
        }

        return null;
    }
}
