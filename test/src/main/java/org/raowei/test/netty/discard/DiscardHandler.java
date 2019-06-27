package org.raowei.test.netty.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author raowei
 * @date 2019-06-26
 */
public class DiscardHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf bf = (ByteBuf) msg;
        ctx.write(msg);
        ctx.flush();
//        try {
//            while (bf.isReadable()) {
//                System.out.print((char) bf.readByte());
//                System.out.flush();
//            }
//        } finally {
////            ReferenceCountUtil.release(msg);
//        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
