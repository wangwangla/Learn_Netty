package kw.test.embeddedchannel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.channel.embedded.EmbeddedChannel;
import kw.test.buffer.ByteBufferAllocate;

import java.nio.charset.StandardCharsets;

/**
 * 用来测试使用   不允许启动客户端和服务端了
 */
public class EmbeddedChannelDemo {
    public static void main(String[] args) {
        ChannelInboundHandlerAdapter ch1 = new ChannelInboundHandlerAdapter(){
            @Override
            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                super.channelRead(ctx, msg);
            }
        };
        ChannelInboundHandlerAdapter ch2 = new ChannelInboundHandlerAdapter(){
            @Override
            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                super.channelRead(ctx, msg);
            }
        };

        ChannelOutboundHandlerAdapter out1 = new ChannelOutboundHandlerAdapter(){
            @Override
            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                super.write(ctx, msg, promise);
            }
        };

        ChannelOutboundHandlerAdapter out2 = new ChannelOutboundHandlerAdapter(){
            @Override
            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                super.write(ctx, msg, promise);
            }
        };

        EmbeddedChannel channel = new EmbeddedChannel(ch1,ch2,out1,out2);
        //入栈
        channel.writeInbound();


        //出栈
        channel.writeOneOutbound(ByteBufAllocator.DEFAULT.buffer().writeBytes("hello".getBytes()));
    }
}
