package kw.test.net.unblock;

import kw.test.utils.ByteBufferUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class UnBlockServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8811));
        while (true) {
            SocketChannel accept = serverSocketChannel.accept();
            if (accept!=null) {
                ByteBuffer buffer = ByteBuffer.allocate(10);
                accept.read(buffer);
                buffer.flip();
                ByteBufferUtil.debugAll(buffer);
            }
        }
    }
}
