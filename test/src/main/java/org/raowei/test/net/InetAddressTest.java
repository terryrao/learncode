package org.raowei.test.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author raowei
 * @date 2019-06-09
 */
public class InetAddressTest {


    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] address = InetAddress.getAllByName("www.88bank.com");
        for (int i = 0; i < address.length; i++) {
            System.out.println(address[i]);
        }
    }
}
