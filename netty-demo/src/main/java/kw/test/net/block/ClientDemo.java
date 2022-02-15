package kw.test.net.block;

import kw.test.buffer.ByteBufferDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class ClientDemo {
    static final Logger log = LoggerFactory.getLogger(ByteBufferDemo.class);
    public static void main(String[] args) throws Exception {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost",8811));
        SocketAddress address = channel.getLocalAddress();
        log.trace("connect");
        channel.write(StandardCharsets.UTF_8.encode("heelo"));
        System.in.read();
    }
}
