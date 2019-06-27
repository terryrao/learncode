package org.raowei.test.netty.discard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author raowei
 * @date 2019-06-26
 */
public class DiscardClient {


    public static void main(String[] args) {

        Socket socket = null;
        try {
            socket = new Socket("localhost", 8081);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello".getBytes());
            outputStream.flush();
            InputStream inputStream = socket.getInputStream();
            int by = 0;
            while ((by = inputStream.read()) != -1) {
                System.out.print((char) by);
            }
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
