package org.raowei.test.learnjunit.chapter5;


import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * ${DESCRIPTION}
 * create: 2016-07-19 16:10
 *
 * @author admin
 */
public class JettySample {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);
        Context context = new Context(server,"/");
        context.setResourceBase("./pom.xml");
        context.setHandler(new ResourceHandler());
        server.start();
    }



}

