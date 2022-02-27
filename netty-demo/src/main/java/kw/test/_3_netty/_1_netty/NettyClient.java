package kw.test._3_netty._1_netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

import java.net.InetSocketAddress;

/**
 * 连接过程：
 * 1.服务器创建BootServerStrap
 * 2.设置线程组
 * 3.设置通道
 * 4.设置处理器
 * 5.绑定端口
 *
 * ----------------------
 * 6.客户端启动
 * 7.设置线程组
 * 8.设置通道
 * 9.设置处理器
 * 10.连接
 * 11.等待连接上
 *
 *
 *
 * 12.服务器连接上  执行服务器中的处理器
 * 13.得到通道
 * 14.发送数据
 * 15.执行客户端的处理器，需要发送数据，那么就需要将字符转换buf
 *
 *
 * 16.服务器得到read事件
 * 17.执行服务器端的处理器
 */
public class NettyClient {
    public static void main(String[] args) throws Exception {
        new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast(new StringDecoder());
                    }
                })
                .connect("127.0.0.1",8011)
                .sync()
                .channel()
                .writeAndFlush("xx");

    }
}
