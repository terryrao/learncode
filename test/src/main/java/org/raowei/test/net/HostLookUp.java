package org.raowei.test.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author raowei
 * @date 2019-06-12
 */
public class HostLookUp {


    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            for (String host : args) {
                System.out.println(lookup(host));
            }
        }else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter names or Ip address ,Enter exit to quit.");
            while (true) {
                String host = reader.readLine();
                if (host.equals("exit")) {
                    break;
                }

                System.out.println(lookup(host));
            }
        }
    }

    private static String lookup(String host) {
        try {
            InetAddress node = InetAddress.getByName(host);
            if (isHostName(host)) {
                return node.getHostAddress();
            }else {
               return node.getHostName();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "can not found the host" + host;
        }
    }

    private static boolean isHostName(String host) {
        if(host.contains(":")) {
            return false;
        }
        char[] chars = host.toCharArray();

        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                if (aChar != '.') {
                    return true;
                }
            }
        }
        return false;
    }
}
