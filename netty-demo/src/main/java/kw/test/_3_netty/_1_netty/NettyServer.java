package kw.test._3_netty._1_netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServer {
    /**
     * 1.初始化并且注册channel
     * - 通过刚才的刚才创建channel
     * - 初始化channel
     *  - 从通道得到pipline
     *  - 给pipeline设置处理器
     * - 注册通道
     *  - 通过获取next()【EventLoop】注册
     *  - 通过刚才创建的channel
     *  - unsafe()  doRegister(因为slector都是通过channel进行注册的，这里调用的是channel的方法)
     * 2.得到channle对象   final Channel channel = regFuture.channel();
     * 3.绑定
     * - 通过一个线程完成
     * -
     *
     * @param args
     */
    public static void main(String[] args) {
        new ServerBootstrap()
                //如果是一个，那么就子和夫使用同一个，否则使用分开   给group和childGroup
                .group(new NioEventLoopGroup())
                //吧class传递进去   得到构造器  通过构造器创建实例
                .channel(NioServerSocketChannel.class)
                //将参数给 childHandler
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioServerSocketChannel) throws Exception {
                        nioServerSocketChannel.pipeline().addLast(new StringDecoder());
                        nioServerSocketChannel.pipeline().addLast(new StringEncoder());
                        nioServerSocketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>(){
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                                System.out.println(msg);
                            }
                        });
                    }
                })
                //绑定才是重点
                .bind(8011);
    }
}
