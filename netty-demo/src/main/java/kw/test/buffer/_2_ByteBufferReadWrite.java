package kw.test.buffer;

import kw.test.utils.ByteBufferUtil;

import java.nio.ByteBuffer;

public class _2_ByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte)0x61);
        ByteBufferUtil.debugAll(buffer);
        buffer.put(new byte[]{0x62,0x63});
        ByteBufferUtil.debugAll(buffer);
        buffer.flip();
        buffer.compact();
        buffer.get();
    }
}
