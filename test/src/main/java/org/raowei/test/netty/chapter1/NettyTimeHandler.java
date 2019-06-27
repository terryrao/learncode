package org.raowei.test.netty.chapter1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author raowei
 * @date 2019-06-26
 */
public class NettyTimeHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buffer = ctx.alloc().buffer(4);

        buffer.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
        ChannelFuture channelFuture = ctx.writeAndFlush(buffer);
        channelFuture.addListener(future -> ctx.close());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
