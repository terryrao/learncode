package org.raowei.test.learnjunit.chapter7;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 * create: 2016-07-19 17:36
 *
 * @author admin
 */
public class MockAccountManager implements AccountManager {
    private Map<String,Account> accounts = new HashMap<>();

    public void addAccount (String userId,Account account) {
        this.accounts.put(userId,account);
    }
    @Override
    public Account findAccountForUser(String userId) {
        return this.accounts.get(userId);
    }

    @Override
    public void updateAccount(Account account) {
        // do nothing
    }
}
