package kw.test._2_net._1_block;

import kw.test._1_buffer._1_ByteBufferDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class _1_ClientDemo {
    static final Logger log = LoggerFactory.getLogger(_1_ByteBufferDemo.class);
    public static void main(String[] args) throws Exception {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost",8811));
//        SocketAddress address = channel.getLocalAddress();
        log.trace("connect");
        channel.write(StandardCharsets.UTF_8.encode("hello"));
        System.in.read();
    }
}
