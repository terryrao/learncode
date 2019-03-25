package org.raowei.test.learnjunit.chapter7;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * ${DESCRIPTION}
 * create: 2016-07-20 14:12
 *
 * @author admin
 */
public class TestWebClientJMock {
    private Mockery context = new JUnit4Mockery() {
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };

    @Test
    public void testGetContentOk() throws Exception {
        ConnectionFactory mock = context.mock(ConnectionFactory.class);
        InputStream stream = context.mock(InputStream.class);
        context.checking(new Expectations() {
            {
                oneOf(mock).getData();
                will(returnValue(stream));
                atLeast(1).of(stream).read();
                will(onConsecutiveCalls(
                        returnValue((int) 'W'),
                        returnValue((int) 'o'),
                        returnValue((int) 'r'),
                        returnValue((int) 'k'),
                        returnValue((int) 's'),
                        returnValue((int) '!'),
                        returnValue(-1) // 必不可少
                ));

                oneOf(stream).close();
            }
        });
        WebClient webClient = new WebClient();
        String content = webClient.getContent(mock);
        Assert.assertEquals("Works!",content);

    }


}
