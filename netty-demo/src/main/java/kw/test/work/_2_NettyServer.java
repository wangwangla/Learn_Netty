package kw.test.work;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class _2_NettyServer {
    public static void main(String[] args) {
        //复制组装netty组件  启动服务器

        DefaultEventLoopGroup defaultEventLoopGroup = new DefaultEventLoopGroup();
        new ServerBootstrap()



                //某个比较的浪费时间，会造成大量的堵塞，
                //可以使用单独的一个线程来进行处理
                //




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



                                //这里进行设置   如果很浪费事件，就可以 使用单独的一个线程进行处理
                                nioServerSocketChannel.pipeline().addLast(defaultEventLoopGroup,"",new ChannelInboundHandlerAdapter(){
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
