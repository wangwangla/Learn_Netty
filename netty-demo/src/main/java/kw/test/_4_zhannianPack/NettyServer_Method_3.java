package kw.test._4_zhannianPack;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import kw.test.utils.ByteBufferUtil;

import java.nio.charset.StandardCharsets;

/**
 * 使用lineBaseFrameDecoder
 */
public class NettyServer_Method_3 {
    static  int i = 0;
    public static void main(String[] args) {
        new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024,0,4));
//                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new MessageDecoder());
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                super.channelRead(ctx, msg);
//                                ByteBufferUtil.debugAll(msg);
                                System.out.println(i+"====="+msg);

                                if(msg instanceof ByteBuf){
                                    ByteBuf msg1 = (ByteBuf) (msg);
                                    byte b = msg1.readByte();
                                    byte[] by = new byte[b];
                                    msg1.readBytes(by);
                                    String st = new String(by);
                                    System.out.println(i+"------"+st);
                                }
                                i++;
                            }
                        });
                    }
                }).bind(8888);
    }
}
