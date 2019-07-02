package org.raowei.test.netty.chapter5;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author raowei
 * @date 2019-07-02
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    private int counter = 0;
    static String req = "Welcome to netty." + EchoServerHandler.delimiter;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel start ");

        for (int i = 0; i < 10; i++) {
//            ctx.writeAndFlush(req);
            ctx.writeAndFlush(Unpooled.copiedBuffer(req.getBytes()));
        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("this is " + ++counter + " times  received server  [" + body + "]");

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
