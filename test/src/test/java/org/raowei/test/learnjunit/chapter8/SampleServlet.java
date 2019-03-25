package org.raowei.test.learnjunit.chapter8;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ${DESCRIPTION}
 * create: 2016-07-20 16:50
 *
 * @author admin
 */
public class SampleServlet extends HttpServlet{

    public boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }

        String  authenticated = (String) session.getAttribute("authenticated");
        return Boolean.valueOf(authenticated);
    }

}
