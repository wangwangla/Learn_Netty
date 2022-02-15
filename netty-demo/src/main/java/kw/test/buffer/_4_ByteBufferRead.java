package kw.test.buffer;

import java.nio.ByteBuffer;

public class _4_ByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});
        buffer.flip();

        //读取4个
        buffer.get(new byte[4]);

        //从头开始
        buffer.rewind();

        buffer.get();

        buffer.mark();
        buffer.reset(); //跳转到mark

//        不会改变position
//        buffer.get(index);
    }
}
