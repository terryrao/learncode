package org.raowei.test.net;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @author raowei
 * @date 2019-06-09
 */
public class SystemPropertiesTest {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            Object key = enumeration.nextElement();
            System.out.println(key + ":" + properties.get(key));
        }
    }
}
