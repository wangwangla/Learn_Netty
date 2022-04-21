package kw.test._6_xieyi;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.MessageToMessageEncoder;
import kw.test._6_xieyi.header.Header;
import kw.test._6_xieyi.message.Message;
import kw.test._6_xieyi.message.MessageBody;
import kw.test._6_xieyi.serialize.MessageSerilze;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class NettyMessageEnDecoder extends MessageToMessageCodec<ByteBuf,Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {
        ByteBuf buffer = ctx.alloc().buffer();
        Header header = msg.getHeader();
        buffer.writeInt(header.getCrcCode());
        buffer.writeInt(header.getLength());
        buffer.writeLong(header.getSessionId());
        buffer.writeByte(header.getType());
        buffer.writeByte(header.getPriority());
        buffer.writeInt(header.getAttachment().size());
//        String key = null;
//        byte[] keyArray = null;
//        Object value = null;
//        for (Map.Entry<String, Object> param : header.getAttachment().entrySet()) {
//            key = param.getKey();
//            keyArray = key.getBytes(StandardCharsets.UTF_8);
//            buffer.writeInt(keyArray.length);
//            buffer.writeBytes(keyArray);
//            value = param.getValue();
//        }
        if (msg.getBody()!=null){
            byte[] encoder = MessageSerilze.java.encoder(msg.getBody());
            buffer.writeInt(encoder.length);
            buffer.writeBytes(encoder);
            out.add(buffer);
        }else {
            buffer.writeInt(0);
            out.add(buffer);
        }

    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        Header header = new Header();
        header.setCrcCode(msg.readInt());
        header.setLength(msg.readInt());
        header.setSessionId(msg.readLong());
        header.setType(msg.readByte());
        header.setPriority(msg.readByte());
        int attr = msg.readInt();
        System.out.println(attr);
        int bodyLength = msg.readInt();
        byte[] b = new byte[bodyLength];
        msg.readBytes(b);
        MessageBody decoder = MessageSerilze.java.decoder(b, MessageBody.class);
        Message message  = new Message();
        message.setHeader(header);
        message.setBody(decoder);
        out.add(message);
    }
}
