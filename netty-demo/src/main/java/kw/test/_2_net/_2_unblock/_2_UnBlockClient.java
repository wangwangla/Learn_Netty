package kw.test._2_net._2_unblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class _2_UnBlockClient {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost",8811));
        channel.write(StandardCharsets.UTF_8.encode("hello"));
    }
}
