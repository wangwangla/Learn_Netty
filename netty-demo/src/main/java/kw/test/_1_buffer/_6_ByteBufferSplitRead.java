package kw.test._1_buffer;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class _6_ByteBufferSplitRead {
    public static void main(String[] args) {
        ByteBuffer b1 = ByteBuffer.allocate(3);
        ByteBuffer b2 = ByteBuffer.allocate(3);
        ByteBuffer b3 = ByteBuffer.allocate(3);
        try (RandomAccessFile file = new RandomAccessFile("hello/demo.txt","rw")){
            file.getChannel().read(new ByteBuffer[]{b1,b3,b2});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
