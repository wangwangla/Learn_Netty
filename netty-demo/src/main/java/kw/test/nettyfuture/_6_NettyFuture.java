package kw.test.nettyfuture;

import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.concurrent.Callable;

public class _6_NettyFuture {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        EventLoop next = group.next();
        Future<Integer> submit = next.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 0;
            }
        });

//         同步
//        Integer integer = submit.get();


        //nio线程
        //和jdk的区别就是可以异步的获取结果
        submit.addListener(new GenericFutureListener<Future<? super Integer>>() {
            @Override
            public void operationComplete(Future<? super Integer> future) throws Exception {
                System.out.println(future.getNow());
            }
        });
    }
}
