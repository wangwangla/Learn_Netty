package kw.test._1_buffer;

import kw.test.utils.ByteBufferUtil;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

public class _5_ByteBufferString {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes());
        ByteBufferUtil.debugAll(buffer);

        ByteBuffer hello = StandardCharsets.UTF_8.encode("hello");
        ByteBufferUtil.debugAll(hello);

        ByteBuffer wrap = ByteBuffer.wrap("hello".getBytes());
        ByteBufferUtil.debugAll(wrap);

        CharBuffer decode = StandardCharsets.UTF_8.decode(wrap);


    }
}
