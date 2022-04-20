package kw.test._2_net._3_select;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class _3_SelectorServer {
    public static void main(String[] args) throws Exception {
        //管理多个channel
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //通过channel建立连接   注册
        SelectionKey registerKey = serverSocketChannel.register(selector, 0, null);
        //关心什么操作
        /**
         * 类型：
         * - accept
         * - connect
         * - read
         * - write
         */
        registerKey.interestOps(SelectionKey.OP_ACCEPT);
        serverSocketChannel.bind(new InetSocketAddress(8811));
        while (true){
            //通过select方法进行阻塞，等待事件前来/
            //有事件没处理会不阻塞
            selector.select();
            //处理事件的key  首先得到集合
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator(); // accept, read
            while (iter.hasNext()){
                SelectionKey s = iter.next();

                /**
                 *  解释为什么需要自己删除key上的事件
                 *
                 *  开始注册channel，当有事件发生的时候，在事件key有一个事件加入，处理之后会标记为已经处理
                 *  下一次有事件的时候，再次加入，在遍历，但是里面有一个已经处理的事件
                 *
                 *
                 *
                 * 两个集合  一个自己注册的，一个是事件加入的
                 */

                iter.remove();



                /*************************事件需要处理，不处理就一直执行***********************************/
                //那个channel的消息
//                ServerSocketChannel channel = (ServerSocketChannel) next.channel();
//                channel.accept();//处理   如果不处理就一直执行
//
//                //不处理
//                next.cancel();
                /*************************事件需要处理，不处理就一直执行***********************************/



//                连接  关闭
//                正常断开   会发送一个-1
//                异常断开  异常断开会抛出异常


//
//                ServerSocketChannel channel = (ServerSocketChannel) next.channel();
//                channel.accept();
//                SelectionKey register1 = channel.register(selector, 0, null);
//                register1.interestOps(SelectionKey.OP_READ);


/**
 *
 *
 * 消息边界？？
 *
 * 比如发送汉字，一个汉字gdk  3字节
 * 接收使用4个字节，每次只能接受1个半，不是完整的就会出问题
 *
 *
 *
 * 沾包   半包
 *
 *
 *
 * 处理：
 * 约定长度：可能造成浪费
 *
 * 使用特殊分隔符
 *
 * 先传输大小，在传输内容
 *
 * http1
 * 类型    长度   内容
 *
 * Http2
 *
 * 长   类型   内容
 */


                if (s.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel) s.channel();
                    channel.accept();
                    SelectionKey register1 = channel.register(selector, 0, null);
                    register1.interestOps(SelectionKey.OP_READ);
                }else if (s.isReadable()){
                    try {
                        SocketChannel channel = (SocketChannel) s.channel();
                        ByteBuffer allocate = ByteBuffer.allocate(16);
                        int read = channel.read(allocate);
                        //正常关闭
                        if (read == -1){
                            s.cancel();
                        }
                        allocate.flip();
                    }catch (Exception e){
                        //异常关闭
                        e.printStackTrace();
                        s.cancel(); //将key删除
                    }
                }
            }
        }
    }
}
