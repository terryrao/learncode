package org.raowei.test.learnjunit.chapter7;

/**
 * ${DESCRIPTION}
 * create: 2016-07-19 17:26
 *
 * @author admin
 */
public class Account {
    private String accountId;
    private long balance;

    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public void debit(long amount) {
        this.balance -= amount;
    }

    public void credit(long amount) {
        this.balance += amount;
    }

    public long getBalance() {
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }
}
