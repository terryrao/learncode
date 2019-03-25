package org.raowei.test.learnjunit.chapter7;

import java.io.InputStream;

/**
 * ${DESCRIPTION}
 * create: 2016-07-20 10:53
 *
 * @author admin
 */
public class WebClient {

    public String getContent(ConnectionFactory connectionFactory) throws Exception {
        String result;
        StringBuffer content = new StringBuffer();
        InputStream is;
        is = connectionFactory.getData();
        int count;
        while (-1 != (count = is.read())) {
            content.append(new String(Character.toChars(count)));
        }
        result = content.toString();

        is.close();
        return result;
    }
}
