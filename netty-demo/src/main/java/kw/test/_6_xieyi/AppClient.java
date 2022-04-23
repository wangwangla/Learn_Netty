package kw.test._6_xieyi;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import kw.test._6_xieyi.header.Header;
import kw.test._6_xieyi.message.Message;
import kw.test._6_xieyi.message.MessageBody;

/**
 * 私有协议
 */
public class AppClient {
    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new StringEncoder());
                            ch.pipeline().addLast(new NettyMessageEnDecoder());
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    super.channelActive(ctx);
                                    Message message  = new Message();
                                    message.setBody(new MessageBody());
                                    Header header = new Header();
                                    header.setType((byte) 4);
                                    message.setHeader(header);
                                    ctx.writeAndFlush(message);
                                }
                            });
                        }
                    })
                    .connect("127.0.0.1",8888)
                    .sync()
                    .channel()
                    .closeFuture();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
