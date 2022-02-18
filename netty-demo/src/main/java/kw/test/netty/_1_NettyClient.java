package kw.test.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioChannelOption;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

public class _1_NettyClient {
    public static void main(String[] args) throws Exception {
        new Bootstrap()
                //设置组
                .group(new NioEventLoopGroup())
                //设置通道
                .channel(NioSocketChannel.class)
                //设置处理器
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast(new StringEncoder());

                    }
                })
                //连接
                .connect(new InetSocketAddress("localhost",8811))
                //等连接完成
                .sync()
                //得到通道
                .channel()
                //发送数据
                .writeAndFlush("hello");
    }
}
