package kw.test._4_zhannianPack;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 *  使用指定符号分隔符
* write msgwrite msg
write msg
write msgwrite msg
write msg
* */
public class NettyClient_Method_2 {
    public static void main(String[] args) throws InterruptedException {
        new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ByteBuf buf = Unpooled.copiedBuffer("_".getBytes());
                        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,buf));
                        ch.pipeline().addLast(new StringEncoder());
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                super.channelActive(ctx);
//                                0=====write msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite m
//                                  1=====sgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msgwrite msg
//                                半包
//                                StringBuilder builder = new StringBuilder();
//                                for (int i = 0; i < 1000; i++) {
//                                    builder.append("write msg");
//                                }
//                                ctx.writeAndFlush(builder.toString());


//                                粘包
                                for (int i = 0; i < 1000; i++) {
                                    ctx.writeAndFlush("write msg_");
                                }
                            }
                        });
                    }
                }).connect("127.0.0.1",8888)
                .sync()
                .channel();

    }
}
