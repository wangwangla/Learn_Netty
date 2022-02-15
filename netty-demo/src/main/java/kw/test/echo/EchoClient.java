package kw.test.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Channel channel = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {

                    }
                })
                .connect("localhost",8811)
                .sync()
                .channel();
        channel.closeFuture().addListener(future -> {
            group.shutdownGracefully();
        });
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
        }).start();
    }
}
