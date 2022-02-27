package kw.test._3_netty._2_nettysrc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 1.创建channel   1
 * 2.创建selector   2
 * 3.注册     3
 * 4.绑定端口
 * 5.关注事件
 */
public class NettyServersrc {
    public static void main(String[] args) {
        new ServerBootstrap()  //只创建对象
                .group(new NioEventLoopGroup())  //设置了一个变量   返回自己
                .channel(NioServerSocketChannel.class) //设置了一个工厂、  使用反射创建对象
                //设置值   handler处理器
                .childHandler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel nioServerSocketChannel) throws Exception {
                        nioServerSocketChannel.pipeline().addLast(new StringDecoder());
                    }
                })
                //绑定  端口
                .bind(8011);

        /**
         * 绑定方法：
         * 1.创建channel，然后初始化channel
         *  将handler设置到channel通道上。 pipline
         * 2、将通道注册到eventLoop上（ChannelFuture）
         * 3.等待连接返回
         * 4.
         */
    }

}
