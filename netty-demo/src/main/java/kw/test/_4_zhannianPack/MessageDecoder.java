package kw.test._4_zhannianPack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MessageDecoder extends MessageToMessageCodec<ByteBuf,String> {
    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeInt(msg.length());
        buffer.writeBytes(msg.getBytes());
        out.add(buffer);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        int length = msg.readInt();
        byte[] bytes = new byte[length];
        msg.readBytes(bytes);
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes(bytes);
        ByteBuffer buffex = ByteBuffer.allocate(bytes.length);
        buffex.put(bytes);
        buffex.flip();
        CharBuffer decode = StandardCharsets.UTF_8.decode(buffex);
        out.add(new StringBuffer(decode));
    }
}
