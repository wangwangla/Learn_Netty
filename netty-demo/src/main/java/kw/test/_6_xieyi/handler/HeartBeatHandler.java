package kw.test._6_xieyi.handler;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import kw.test._6_xieyi.header.Header;
import kw.test._6_xieyi.message.Message;
import kw.test._6_xieyi.message.MessageBody;

import java.util.concurrent.TimeUnit;

public class HeartBeatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof Message){
            if (((Message)(msg)).getHeader().getType() == 3) {
                System.out.println("server res xintiao");
            }
        }
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
//        Message message  = new Message();
//        message.setBody(new MessageBody());
//        Header header = new Header();
//        header.setType((byte) 2);
//        message.setHeader(header);
//        ctx.writeAndFlush(message);
    }
}
