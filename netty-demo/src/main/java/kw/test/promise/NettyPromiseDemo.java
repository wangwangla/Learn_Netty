package kw.test.promise;

import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultPromise;

public class NettyPromiseDemo {
    public static void main(String[] args) {
        EventLoopGroup loopGroup = new NioEventLoopGroup();
        EventLoop next = loopGroup.next();
        DefaultPromise<Integer> promise = new DefaultPromise<>(next);
        new Thread(()->{
            promise.setSuccess(10);
        });
        System.out.println(promise.getNow());
    }
}
