package kw.test._2_net._2_unblock;

import kw.test.utils.ByteBufferUtil;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/***
 * 一个线程 不断的进步遍历
 *
 *
 * 所以使用selector  事件处理
 */
public class _2_UnBlockServer {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false); //不堵塞
        serverSocketChannel.bind(new InetSocketAddress(8811));
        ArrayList<SocketChannel> channels = new ArrayList<>();
        while (true) {
            SocketChannel channel = serverSocketChannel.accept();  //不等待   while会一直空转
            if (channel!=null) {
                channels.add(channel);
                channel.configureBlocking(false);
            }
            for (int i = 0; i < channels.size(); i++) {
                buffer.clear();
                int read = channels.get(i).read(buffer);
                if (read>0) {
                    buffer.flip();
                    ByteBufferUtil.debugAll(buffer);
                }
            }
        }
    }
}
