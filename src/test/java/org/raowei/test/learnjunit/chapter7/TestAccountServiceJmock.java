package org.raowei.test.learnjunit.chapter7;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ${DESCRIPTION}
 * create: 2016-07-20 11:41
 *
 * @author admin
 */
public class TestAccountServiceJmock {
    private Mockery context = new JUnit4Mockery();
    private AccountManager mockAccountManager;

    @Before
    public void setUp() {
        mockAccountManager = context.mock(AccountManager.class);
    }

    @Test
    public void testTransferOk() {
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);
        context.checking(new Expectations() {
            {
                oneOf(mockAccountManager).findAccountForUser("1");
                will(returnValue(senderAccount));
                oneOf(mockAccountManager).findAccountForUser("2");
                will(returnValue(beneficiaryAccount));
                oneOf(mockAccountManager).updateAccount(senderAccount);
                oneOf(mockAccountManager).updateAccount(beneficiaryAccount);
            }
        });
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1","2",50);
        Assert.assertEquals(150,senderAccount.getBalance());
        Assert.assertEquals(150,beneficiaryAccount.getBalance());
    }


}
