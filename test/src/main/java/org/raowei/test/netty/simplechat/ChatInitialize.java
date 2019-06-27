package org.raowei.test.netty.simplechat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author raowei
 * @date 2019-06-27
 */
public class ChatInitialize extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("frame",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        ch.pipeline().addLast("decoder",new StringDecoder());
        ch.pipeline().addLast("encoder",new StringEncoder());
        ch.pipeline().addLast("myhander",new ChatServerHandler());
        System.out.println("SimpleChatClient:" + ch.remoteAddress() + "连接上");
    }
}
