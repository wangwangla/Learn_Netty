package kw.test._2_net.zhanpack;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class _4_Clinet {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost",8811));
        channel.write(Charset.defaultCharset().encode("0123111111111111111111111111111111111111111111"));
        System.in.read();
    }
}
