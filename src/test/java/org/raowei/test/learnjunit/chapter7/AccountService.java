package org.raowei.test.learnjunit.chapter7;

/**
 * ${DESCRIPTION}
 * create: 2016-07-19 17:30
 *
 * @author admin
 */
public class AccountService {

    private AccountManager accountManager;

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void transfer(String senderId,String beneficiaryId,long amount) {
        Account sender = this.accountManager.findAccountForUser(senderId);
        Account beneficiary = this.accountManager.findAccountForUser(beneficiaryId);
        sender.debit(amount);
        beneficiary.credit(amount);
        this.accountManager.updateAccount(sender);
        this.accountManager.updateAccount(beneficiary);
    }




}
