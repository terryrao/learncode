package org.raowei.test.learnjunit.chapter7;

/**
 * ${DESCRIPTION}
 * create: 2016-07-19 17:28
 *
 * @author admin
 */
public interface AccountManager {
    Account findAccountForUser(String userId);

    void updateAccount(Account account);
}
