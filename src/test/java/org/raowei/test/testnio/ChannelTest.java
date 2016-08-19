package org.raowei.test.testnio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

/**
 * create: 2016-08-19 14:58
 *
 * @author terryrao
 */
public class ChannelTest {

    @Test
    public void test1() throws IOException {

        RandomAccessFile file = new RandomAccessFile("H:\\logs\\p2pweb\\web.log","rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int byteRead = channel.read(buffer);
        while (byteRead != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }
            buffer.clear();
            byteRead = channel.read(buffer);
        }
        file.close();
    }



    @Test
    public void test2() throws IOException {
        Selector selector = Selector.open();
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("172.16.105.74",8080));

        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0)
                continue;
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach((key) -> {
                if (key.isAcceptable()) {
                    System.out.println("a connection was accepted by a ServerSocketChannel");
                }else if (key.isConnectable()) {
                    System.out.println(" a connection was established with a remote server.");
                }else if (key.isReadable()) {
                    System.out.println("a channel is ready for reading");
                }else if (key.isWritable()) {
                    System.out.println("a channel is ready for writing");
                }
            });
        }



    }
}
