package kw.test.buffer;

import java.nio.ByteBuffer;

/**
 * class java.nio.HeapByteBuffer
 * class java.nio.DirectByteBuffer
 */
public class ByteBufferAllocate {
    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(10).getClass());
        System.out.println(ByteBuffer.allocateDirect(10).getClass());
    }
}
