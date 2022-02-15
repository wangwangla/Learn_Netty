package kw.test.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class _7_ByteBufferWrite {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("","rw")){
            FileChannel channel = file.getChannel();
            channel.write(new ByteBuffer[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
