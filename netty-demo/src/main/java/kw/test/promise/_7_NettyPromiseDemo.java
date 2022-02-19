package kw.test.promise;

import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class _7_NettyPromiseDemo {
    public static void main(String[] args) {
        EventLoopGroup loopGroup = new NioEventLoopGroup();
        EventLoop next = loopGroup.next();
        DefaultPromise<Integer> promise = new DefaultPromise<>(next);
        new Thread(()->{
            promise.setSuccess(10);
        });
        System.out.println(promise.getNow());

        promise.addListener(new GenericFutureListener<Future<? super Integer>>() {
            @Override
            public void operationComplete(Future<? super Integer> future) throws Exception {
                System.out.println(future.get());
            }
        });
    }
}
