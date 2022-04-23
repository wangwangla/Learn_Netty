package kw.test._6_xieyi;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.local.LocalEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LoggingHandler;
import kw.test._6_xieyi.handler.CHeartBeatHandler;
import kw.test._6_xieyi.header.Header;
import kw.test._6_xieyi.message.Message;
import kw.test._6_xieyi.message.MessageBody;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 私有协议
 */
public class AppClient {
    private static Channel channel;
    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    public static void main(String[] args) {
        final NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            extracted(group);

            channel.closeFuture();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            channel.close();
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    executorService.execute(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                extracted(group);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });
//                }
//            });
        }
    }

    private static void extracted(NioEventLoopGroup group) throws InterruptedException {
        channel = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new StringEncoder());
                        ch.pipeline().addLast(new LoggingHandler());
                        ch.pipeline().addLast(new NettyMessageEnDecoder());
                        ch.pipeline().addLast(new CHeartBeatHandler());
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                super.channelActive(ctx);
                                Message message = new Message();
                                message.setBody(new MessageBody());
                                Header header = new Header();
                                header.setType((byte) 4);
                                message.setHeader(header);
                                ctx.writeAndFlush(message);
                            }
                        });
                    }
                })
                .connect("127.0.0.1", 8888)
                .sync()
                .channel();
//        channel.close();
//                .closeFuture();
//        channelFuture.channel().close().sync();


    }

    private static void close() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                channel.close();
            }
        };
        timer.schedule(timerTask,20,10);
    }
}
