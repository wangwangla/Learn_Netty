package kw.test.src;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.channels.Selector;

/**
 * 几个步骤：
 * 1.  Selector selector = Selector.open();
 *
 * NioEventLoop.class
 *
 *  private NioEventLoop.SelectorTuple openSelector() {
 *    final AbstractSelector unwrappedSelector;
 *    try {
 *        unwrappedSelector = this.provider.openSelector();
 *    } catch (IOException var7) {
 *         throw new ChannelException("failed to open a new selector", va  r7);
 *   }
 * }
 *
 *
 *
 *
 *  2.ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
 *  //通过channel建立连接   注册
 *  3.SelectionKey register = serverSocketChannel.register(selector, 0, null);
 *    AbstractNioChannel.class
 *
 *     protected void doRegister() throws Exception {
 *         boolean selected = false;
 *
 *         while(true) {
 *             try {
 *                  this-->nioServerScoketChannel
 *                 this.selectionKey = this.javaChannel().register(this.eventLoop().unwrappedSelector(), 0, this);
 *                 return;
 *             } catch (CancelledKeyException var3) {
 *                 if (selected) {
 *                     throw var3;
 *                 }
 *
 *                 this.eventLoop().selectNow();
 *                 selected = true;
 *             }
 *         }
 *     }
 *
 *
 *
 *
 *
 *
 *
 *  register.interestOps(SelectionKey.OP_ACCEPT);
 *  serverSocketChannel.bind(new InetSocketAddress(8811));
 */
public class NettySrcServer {
    public static void main(String[] args) {

        new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {

                    }
                })
                .bind(8088);
    }
}
