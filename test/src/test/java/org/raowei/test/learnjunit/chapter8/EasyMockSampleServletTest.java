package org.raowei.test.learnjunit.chapter8;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * ${DESCRIPTION}
 * create: 2016-07-20 16:57
 *
 * @author admin
 */
public class EasyMockSampleServletTest {

    private SampleServlet servlet;
    private HttpServletRequest mockHttpServletRequest;
    private HttpSession mockHttpSession;

    @Before
    public void setUp() {
        servlet = new SampleServlet();
        mockHttpServletRequest = createMock(HttpServletRequest.class);
        mockHttpSession = createMock(HttpSession.class);
    }


    @Test
    public void testIsAuthenticatedAuthenticated() {
        expect(mockHttpServletRequest.getSession(eq(false))).andReturn(mockHttpSession);
        expect(mockHttpSession.getAttribute("authenticated")).andReturn("true");
        replay(mockHttpServletRequest);
        replay(mockHttpSession);
        assertTrue(servlet.isAuthenticated(mockHttpServletRequest));
    }

    @Test
    public void testIsAuthenticatedNoAuthenticated() {
        expect(mockHttpSession.getAttribute(eq("authenticated"))).andReturn("false");
        replay(mockHttpSession);
        expect(mockHttpServletRequest.getSession(eq(false))).andReturn(mockHttpSession);
        replay(mockHttpServletRequest);
        assertFalse(servlet.isAuthenticated(mockHttpServletRequest));
    }

    @Test
    public void testIsAuthenticateNoSession() {
        expect(mockHttpServletRequest.getSession(eq(false))).andReturn(null);
        replay(mockHttpServletRequest);
        replay(mockHttpSession);
        assertFalse(servlet.isAuthenticated(mockHttpServletRequest));
    }

    @After
    public void tearDown() {
        verify(mockHttpServletRequest);
        verify(mockHttpSession);
    }
}
