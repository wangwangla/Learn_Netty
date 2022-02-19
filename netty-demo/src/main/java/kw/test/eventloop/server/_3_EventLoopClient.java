package kw.test.eventloop.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class _3_EventLoopClient {
    public static void main(String[] args) throws Exception{
        ChannelFuture future = new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast("handler1", new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                super.channelRead(ctx, msg);
                            }
                        });
                    }
                }).connect(new InetSocketAddress("localhost", 8811));
        future.sync();//sync方法 通过此同步方法  等到连接连上为止   连接是通过nio线程


        //等待结果也不是主线程    通过异步处理
//        nio连接完成之后，会调用operation Complete方法
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                并不是在主线程中完成的
                channelFuture.channel().writeAndFlush("hello");  //通过nio线程来回调这个方法
            }
        });

    }
}
