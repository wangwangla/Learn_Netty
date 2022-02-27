package kw.test._1_buffer;

import java.nio.ByteBuffer;

/***
 * 创建之后大小不可以改变
 *
 * 堆 ： 读写效率低   jvm垃圾回收  垃圾回收会不断地复制内存，进行垃圾回收
 * 直接内存：读写快
 */
public class _3_ByteBufferAllocate {
    public static void main(String[] args) {
        //堆
        ByteBuffer allocate = ByteBuffer.allocate(10);
        //直接内存
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
    }
}
