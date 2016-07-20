package org.raowei.test.learnjunit.chapter7;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ${DESCRIPTION}
 * create: 2016-07-20 10:36
 *
 * @author admin
 */
public class HttpURLConnectionFactory implements ConnectionFactory{
    private URL url;

    public HttpURLConnectionFactory(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getData() throws Exception {
        HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
        return url.openStream();
    }
}
