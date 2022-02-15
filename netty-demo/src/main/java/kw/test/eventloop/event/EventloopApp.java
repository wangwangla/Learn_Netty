package kw.test.eventloop.event;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import java.util.concurrent.TimeUnit;

public class EventloopApp {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup(1);
        System.out.println(group.next());
        System.out.println(group.next());
        System.out.println(group.next());
        System.out.println(group.next());
        System.out.println(group.next());

        group.execute(()->{
            System.out.println("--------------");
        });
        group.next().scheduleAtFixedRate(()->{
            System.out.println("--ss");
        },0,1, TimeUnit.SECONDS);
    }
}
