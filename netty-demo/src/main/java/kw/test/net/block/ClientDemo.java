package kw.test.net.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;

public class ClientDemo {
    public static void main(String[] args) throws Exception {
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("localhost",8811));
        System.out.println("wwwwww");
        ByteBuffer cc = ByteBuffer.allocate(10);
        channel.read(cc);
    }
}
