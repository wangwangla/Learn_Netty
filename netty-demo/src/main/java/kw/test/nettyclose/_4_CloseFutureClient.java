package kw.test.nettyclose;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;

public class _4_CloseFutureClient {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        ChannelFuture channelFuture = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast(new StringEncoder());
                    }
                })
                .connect(new InetSocketAddress("localhost", 8811));
        Channel channel = channelFuture.sync().channel();
        //上面得到通道

        //控制用户在控制台的输入
        new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            while (true){
                String s = scanner.nextLine();
                if ("q".equals(s)){
                    channel.close();

                    break;
                }
                channel.writeAndFlush(s);
            }
        },"write").start();



        // 获取 CloseFuture 对象， 1) 同步处理关闭， 2) 异步处理关闭
        ChannelFuture closeFuture = channel.closeFuture();


        //同步处理，使用close进行堵塞
        /*log.debug("waiting close...");
        closeFuture.sync();
        log.debug("处理关闭之后的操作");*/



        System.out.println(closeFuture.getClass());
        closeFuture.addListener((ChannelFutureListener) future -> {
            System.out.println("处理关闭之后的操作");
            //eventloop中的线程还没有结束
            group.shutdownGracefully();  //优雅停止
        });
    }
}
