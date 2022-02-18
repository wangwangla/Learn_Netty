package kw.test.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class _1_NettyServer {
    public static void main(String[] args) {
        //复制组装netty组件  启动服务器
        new ServerBootstrap()
                //增加server组
                .group(new NioEventLoopGroup())
                //设置通道类型
                .channel(NioServerSocketChannel.class)
                //设置处理器
                .childHandler(
                        new ChannelInitializer<NioServerSocketChannel>() {
                            @Override
                            protected void initChannel(NioServerSocketChannel nioServerSocketChannel) throws Exception {
                                //通道设置处理器
                                //将内容变为string
                                nioServerSocketChannel.pipeline().addLast(new StringDecoder());
                                //读入内容
                                nioServerSocketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                    @Override
                                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                        super.channelRead(ctx, msg);
//                                        log.trace();
//                                        处理之后输出

                                    }
                                });
                            }
                        }
                ).bind(8811);
    }
}
