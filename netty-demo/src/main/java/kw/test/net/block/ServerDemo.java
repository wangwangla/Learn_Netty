package kw.test.net.block;

import kw.test.buffer.ByteBufferDemo;
import kw.test.utils.ByteBufferUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerDemo {
    static final Logger log = LoggerFactory.getLogger(ByteBufferDemo.class);
    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress(8811));
        while (true){
            log.info("connecting -------------------");
            SocketChannel sc = channel.accept();
            sc.read(buffer);
            buffer.flip();
            ByteBufferUtil.debugAll(buffer);
            buffer.clear();
            log.info("data -----------");
        }
    }
}
