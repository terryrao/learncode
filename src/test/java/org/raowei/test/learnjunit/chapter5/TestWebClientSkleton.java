package org.raowei.test.learnjunit.chapter5;

import org.junit.*;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ${DESCRIPTION}
 * create: 2016-07-19 16:20
 *
 * @author admin
 */
public class TestWebClientSkleton {
    @BeforeClass
    public static void setUp() throws Exception {
        Server server = new Server(8081);

        TestWebClientSkleton t = new TestWebClientSkleton();
        Context context = new Context(server, "/testGetContentOk");
        context.setHandler(t.new TestGetContentOkHandler());
        Context notFound = new Context(server,"/testGetContentNotFound");
        notFound.setHandler(t.new TestGetContentNotFoundHandler());
        server.setStopAtShutdown(true);
        server.start();
    }


    @After
    public void tearDowm() {

    }

    @Test
    public void testGetContentOk() throws MalformedURLException {
        WebClient client = new WebClient();
        String content = client.getContent(new URL("http://localhost:8081/testGetContentOk"));
        Assert.assertEquals("it works", content);
    }

    @Test
    public void testGetContentNotFound() throws MalformedURLException {
        WebClient client = new WebClient();
        String content = client.getContent(new URL("http://localhost:8081/testGetContentNotFound"));
        Assert.assertEquals("",content);
    }

    private class TestGetContentOkHandler extends AbstractHandler {

        @Override
        public void handle(String s, HttpServletRequest httpServletRequest
                , HttpServletResponse httpServletResponse, int i) throws IOException, ServletException {
            OutputStream out = httpServletResponse.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("it works");
            writer.flush();
            httpServletResponse.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }


    // file not found
    private class TestGetContentNotFoundHandler extends AbstractHandler {

        @Override
        public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
                , int i) throws IOException, ServletException {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }


}
