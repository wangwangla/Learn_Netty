package kw.test.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class _6_ByteBufferSplitRead {
    public static void main(String[] args) {
        ByteBuffer b1 = ByteBuffer.allocate(3);
        ByteBuffer b2 = ByteBuffer.allocate(3);
        ByteBuffer b3 = ByteBuffer.allocate(3);
        try (RandomAccessFile file = new RandomAccessFile("","rw")){
            file.getChannel().read(new ByteBuffer[]{b1,b3,b2});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
