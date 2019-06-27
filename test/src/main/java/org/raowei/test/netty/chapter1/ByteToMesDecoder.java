package org.raowei.test.netty.chapter1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderAdapter;

import java.util.List;

/**
 * @author raowei
 * @date 2019-06-26
 */
public class ByteToMesDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }

        out.add(in.readBytes(4));
    }
}
