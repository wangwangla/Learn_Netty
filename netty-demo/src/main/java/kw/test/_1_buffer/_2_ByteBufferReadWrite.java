package kw.test._1_buffer;

import kw.test.utils.ByteBufferUtil;

import java.nio.ByteBuffer;

public class _2_ByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);  //创建     堆内存
        buffer.put((byte)0x61); //写入
        ByteBufferUtil.debugAll(buffer);
        buffer.put(new byte[]{0x62,0x63});
        ByteBufferUtil.debugAll(buffer);
        buffer.flip();  //读模式
        buffer.compact();   //移动位置  将数据复制到 开头
        buffer.get(); //获取
    }
}
