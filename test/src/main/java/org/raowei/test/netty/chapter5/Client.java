package org.raowei.test.netty.chapter5;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author raowei
 * @date 2019-07-02
 */
public class Client {


    public void connect(String host, int port) throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(boss)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        ByteBuf delimiter = Unpooled.copiedBuffer(EchoServerHandler.delimiter.getBytes());
                        pipeline.addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new ClientHandler());

                    }
                });
        ChannelFuture sync = b.connect(host, port).sync();
        sync.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        new Client().connect("127.0.0.1", 8090);
    }

}
