package kw.test.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * 默认使用直接内存
 */
public class ByteBufType {
    public static void main(String[] args) {
        //直接内存
        ByteBufAllocator.DEFAULT.directBuffer();
        //堆内存
        ByteBufAllocator.DEFAULT.buffer();
    }
}
