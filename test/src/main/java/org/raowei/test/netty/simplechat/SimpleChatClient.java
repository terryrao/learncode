package org.raowei.test.netty.simplechat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author raowei
 * @date 2019-06-27
 */
public class SimpleChatClient {


    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChatClientInitialize());
        try {
            Channel c = b.connect("localhost", 8082).sync().channel();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                String s = reader.readLine();
                System.out.println(s);
                c.writeAndFlush(s + System.lineSeparator());
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            group.shutdownGracefully();
        }
    }
}
