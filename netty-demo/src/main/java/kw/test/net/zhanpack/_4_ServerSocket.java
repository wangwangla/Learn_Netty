package kw.test.net.zhanpack;

import kw.test.utils.ByteBufferUtil;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class _4_ServerSocket {
    public static void main(String[] args)throws Exception {
        //管理多个channel
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        //通过channel建立连接   注册
        SelectionKey register = serverSocketChannel.register(selector, 0, null);
        //关心什么操作
        register.interestOps(SelectionKey.OP_ACCEPT);
        serverSocketChannel.bind(new InetSocketAddress(8811));
        while (true){
            //通过select方法进行阻塞，等待事件前来/
            //有事件没处理会不阻塞
            selector.select();
            //处理事件的key  首先得到集合
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator(); // accept, read
            while (iter.hasNext()){
                SelectionKey next = iter.next();
                iter.remove();
                if (next.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    channel.configureBlocking(false);
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);


                    ByteBuffer allocate = ByteBuffer.allocate(16);
                    SelectionKey register1 = accept.register(selector, 0, allocate);
//--------------------------------------------------------------------------------------
                    ByteBuffer attachment = (ByteBuffer) next.attachment();
                    if (allocate.position() == allocate.limit()){
//                        扩容
                        ByteBuffer newBuffer = ByteBuffer.allocate(32);
                        attachment.flip();
                        newBuffer.put(attachment);
                        next.attach(newBuffer);  //update
                    }
//--------------------------------------------------------------------------------------


                    register1.interestOps(SelectionKey.OP_READ);
                }else if (next.isReadable()){
                    try {
                        SocketChannel channel = (SocketChannel) next.channel();
                        ByteBuffer allocate = ByteBuffer.allocate(16);
                        int read = channel.read(allocate);
                        //正常关闭
                        if (read == -1){
                            next.cancel();
                        }
                        allocate.flip();
                        ByteBufferUtil.debugAll(allocate);
                    }catch (Exception e){
                        //异常关闭
                        e.printStackTrace();
                        next.cancel(); //将key删除
                    }
                }
            }
        }
    }
}
