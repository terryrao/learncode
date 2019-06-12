package org.raowei.test.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author raowei
 * @date 2019-06-09
 */
public class NetWorkInterfaceTest {

    public static void main(String[] args) throws SocketException {
        NetworkInterface eth0 = NetworkInterface.getByName("en0");
        if (eth0 == null) {
            System.out.println("no such interface ");
        }else {
            Enumeration<InetAddress> inetAddresses = eth0.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {

                InetAddress address = inetAddresses.nextElement();
                System.out.println(address);
            }
        }
    }
}
