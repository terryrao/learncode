package org.raowei.test.learnjunit.chapter7;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * ${DESCRIPTION}
 * create: 2016-07-20 10:34
 *
 * @author admin
 */
public class TestWebClientEasyMock {
    private ConnectionFactory factory;
    private InputStream inputStream;

    @Before
    public void setUp() {
        factory = createMock("factory", ConnectionFactory.class);
        inputStream = createMock("stream", InputStream.class);
    }


    @Test
    public void testGetContentOk() throws Exception {
        expect(factory.getData()).andReturn(inputStream);
        expect(inputStream.read()).andReturn((int) (byte) 'W');
        expect(inputStream.read()).andReturn((int) (byte) 'o');
        expect(inputStream.read()).andReturn((int) (byte) 'r');
        expect(inputStream.read()).andReturn((int) (byte) 'k');
        expect(inputStream.read()).andReturn((int) (byte) 's');
        expect(inputStream.read()).andReturn((int) (byte) '!');
        expect(inputStream.read()).andReturn(-1);
        inputStream.close();
        replay(factory);
        replay(inputStream);
        WebClient webClient = new WebClient();
        String content = webClient.getContent(factory);
        System.out.println(content);
        assertEquals(content,"Works!");
    }


    @Test
    public void testGetContentCannotCloseInputStream() throws Exception {
        expect(factory.getData()).andReturn(inputStream);
        expect(inputStream.read()).andReturn(-1);
        inputStream.close();
        expectLastCall().andThrow(new IOException("cannot close"));


        replay(factory);
        replay(inputStream);

        WebClient webClient = new WebClient();
        String result = webClient.getContent(factory);
        assertNull(result);
    }
    public void tearDown () {
        verify(factory);
        verify(inputStream);
    }
}
