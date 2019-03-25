package org.raowei.test.learnjunit.chapter7;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ${DESCRIPTION}
 * create: 2016-07-20 10:16
 *
 * @author admin
 */
public class TestAccountServiceEasyMock {

    private AccountManager accountManager;

    @Before
    public void setUp() {
        accountManager = EasyMock.createMock("accountManager",AccountManager.class);
    }

    @Test
    public void testTransferOk() {
        Account senderAccount = new Account("1",200);
        Account beneficiaryAccount = new Account("2",100);

        accountManager.updateAccount(senderAccount);
        accountManager.updateAccount(beneficiaryAccount);

        EasyMock.expect(accountManager.findAccountForUser("1")).andReturn(senderAccount);
        EasyMock.expect(accountManager.findAccountForUser("2")).andReturn(beneficiaryAccount);
        EasyMock.replay(accountManager);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(accountManager);
        accountService.transfer("1","2",50);
        Assert.assertEquals(150,senderAccount.getBalance());
        Assert.assertEquals(150,beneficiaryAccount.getBalance());

    }

    @After
    public void tearDown() {
        EasyMock.verify(accountManager);
    }

}
