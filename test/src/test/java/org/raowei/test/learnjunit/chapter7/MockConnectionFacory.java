package org.raowei.test.learnjunit.chapter7;

import java.io.InputStream;

/**
 * ${DESCRIPTION}
 * create: 2016-07-20 10:38
 *
 * @author admin
 */
public class MockConnectionFacory implements ConnectionFactory {
    private InputStream inputStream;

    @Override
    public InputStream getData() throws Exception {
        return inputStream;
    }

    public void setData(InputStream inputStream) {
        this.inputStream = inputStream;
    }


}
