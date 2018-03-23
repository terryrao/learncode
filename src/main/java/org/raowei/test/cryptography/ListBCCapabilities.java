package org.raowei.test.cryptography;

import java.security.Provider;
import java.security.Security;
import java.util.Iterator;

/**
 * 查看提供商提供的算法
 * create: 2017-02-16 10:57
 *
 * @author admin
 */
public class ListBCCapabilities {

    public static void main(String[] args) {
        Provider bc = Security.getProvider("BC");
        Iterator<Object> iterator = bc.keySet().iterator();
        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            if (next.startsWith("Alg.Alias.")) {
                next = next.substring("Alg.Alias.".length());
            }

            String factory = next.substring(0,next.indexOf("."));
            String name = next.substring(factory.length() + 1);
            System.out.println(factory + ": " + name);
        }
    }
}
