package org.raowei.test.net;

import java.io.IOException;
import java.net.Socket;

/**
 * @author raowei
 * @date 2019-06-12
 */
public class SocketInfo {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < args.length; i++) {
            Socket socket = new Socket(args[i],80);
            System.out.println("connect to " + socket.getInetAddress() + " on port " + socket.getPort() +
                    " from " + socket.getLocalAddress() + " on " + socket.getLocalPort());
        }
    }
}
