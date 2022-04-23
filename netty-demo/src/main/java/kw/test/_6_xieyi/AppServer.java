package kw.test._6_xieyi;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class AppServer {
    public static void main(String[] args){
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            new ServerBootstrap()
                    .group(group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new NettyMessageEnDecoder());
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    super.channelRead(ctx, msg);
                                    System.out.println(msg);
                                }
                            });
                        }
                    })
                    .bind(8888)
                    .sync()
                    .channel()
                    .closeFuture();
        }catch (Exception e){
            group.shutdownGracefully();
        }

    }
}
