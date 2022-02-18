package kw.test.work;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class _1_NettyServer {
    public static void main(String[] args) {
        //复制组装netty组件  启动服务器
        new ServerBootstrap()

                //设置组,如果只有一个  那么无论是什么请求，都是通过它处理的
                //可以设置两个，都一个用来处理连接   后面的用来处理读写事件

                //第一个用来处理连接的    后面两个用来处理工作的
                .group(new NioEventLoopGroup(),new NioEventLoopGroup(3))
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
