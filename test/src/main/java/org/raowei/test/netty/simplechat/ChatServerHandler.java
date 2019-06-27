package org.raowei.test.netty.simplechat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author raowei
 * @date 2019-06-26
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

     private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.writeAndFlush("[SERVER] - " +  channel.remoteAddress() + " 加入" + System.lineSeparator());

        channels.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.writeAndFlush("[SERVER] - " + channel.remoteAddress() + "离开 " + System.lineSeparator());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " online");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " offline");
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel incoming = ctx.channel();
        System.err.println(msg + "-- dfdsf");
        for (Channel channel1 : channels) {
            if (incoming != channel1) {
               channel1.writeAndFlush("[" + channel1.remoteAddress() + "]" + msg + System.lineSeparator());
            }else {
                channel1.writeAndFlush("you say: " + msg  + System.lineSeparator());
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:"+incoming.remoteAddress()+"异常");
        cause.printStackTrace();
        ctx.close();
    }
}
