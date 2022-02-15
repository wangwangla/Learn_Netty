package kw.test.slience;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class SlienceDemo {
    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(10);
        buffer.writeBytes(new byte[]{'a'});
        ByteBuf f1 = buffer.slice(0, 5);
        f1.retain();
        // 'a','b','c','d','e', 'x'
        ByteBuf f2 = buffer.slice(5, 5);
        f2.retain();

        buffer.release();
        f1.release();
        f2.release();
    }
}
