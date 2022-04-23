package kw.test._6_xieyi.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import kw.test._6_xieyi.header.Header;
import kw.test._6_xieyi.message.Message;
import kw.test._6_xieyi.message.MessageBody;

import java.util.concurrent.TimeUnit;

public class CHeartBeatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ctx.executor().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Message message  = new Message();
                message.setBody(new MessageBody());
                Header header = new Header();
                header.setType((byte) 3);
                message.setHeader(header);
                ctx.writeAndFlush(message);
            }
        },7,6, TimeUnit.SECONDS);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }


}
