package org.raowei.test.learnjunit.chapter7;

import org.junit.Assert;
import org.junit.Test;

/**
 * ${DESCRIPTION}
 * create: 2016-07-19 17:40
 *
 * @author admin
 */
public class TestAccountService {

    @Test
    public void testTransferOk() {
       MockAccountManager mockAccountManager = new MockAccountManager();
        Account senderAccount = new Account("1",200);
        Account beneficiaryAccoutn = new Account("2",100);
        mockAccountManager.addAccount(senderAccount.getAccountId(),senderAccount);
        mockAccountManager.addAccount(beneficiaryAccoutn.getAccountId(),beneficiaryAccoutn);
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer(senderAccount.getAccountId(),beneficiaryAccoutn.getAccountId(),50);
        Assert.assertEquals(150,senderAccount.getBalance());
        Assert.assertEquals(150,senderAccount.getBalance());

    }
}
