package kw.test.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * 池化思想
 *
 * 4.1之前，Android使用非池化    其他使用池化
 * 4.1之前，默认使用非池化
 */
public class ByteBufPool {
    public static void main(String[] args) {
        //创建     默认300
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer();
        //池化加直接内存
        System.out.println(buffer.getClass());
    }
}
