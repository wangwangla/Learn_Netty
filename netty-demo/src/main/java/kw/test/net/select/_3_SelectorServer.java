package kw.test.net.select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class _3_SelectorServer {
    public static void main(String[] args) throws Exception {
        //管理多个channel
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //通过channel建立连接   注册
        SelectionKey register = serverSocketChannel.register(selector, 0, null);
        //关心什么操作
        /**
         * 类型：
         * - accept
         * - connect
         * - read
         * - write
         */
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





                ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                channel.accept();
                SelectionKey register1 = channel.register(selector, 0, null);
                register1.interestOps(SelectionKey.OP_READ);

                if (next.isAcceptable()){

                }else if (next.isReadable()){
                    try {

                    }catch (Exception e){
                        next.cancel(); //将key删除
                    }
                }
            }
        }
    }
}
