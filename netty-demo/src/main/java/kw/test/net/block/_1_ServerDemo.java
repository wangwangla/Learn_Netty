package kw.test.net.block;

import kw.test.buffer._1_ByteBufferDemo;
import kw.test.utils.ByteBufferUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * block 阻塞的
 * 等待连接的时候进行阻塞
 */
public class _1_ServerDemo {
    static final Logger log = LoggerFactory.getLogger(_1_ByteBufferDemo.class);
    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        //创建服务器
        ServerSocketChannel channel = ServerSocketChannel.open();
        //绑定端口
        channel.bind(new InetSocketAddress(8811));
        while (true){
            log.info("connecting -------------------");//
            //与客户端 进行通信
            SocketChannel sc = channel.accept();//会阻塞
            sc.read(buffer);  //读取的地方，也会进行堵塞
            buffer.flip();
            ByteBufferUtil.debugAll(buffer);
            buffer.clear();

            log.info("data -----------");
        }
    }
}
