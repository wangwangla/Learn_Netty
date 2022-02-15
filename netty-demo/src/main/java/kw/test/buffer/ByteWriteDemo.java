package kw.test.buffer;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class ByteWriteDemo {
    public static void main(String[] args) {
        ByteBuffer str1 = StandardCharsets.UTF_8.encode("hello !");
        ByteBuffer str2 = StandardCharsets.UTF_8.encode("world !");
        ByteBuffer str3 = StandardCharsets.UTF_8.encode("demo !");
        ByteBuffer str4 = StandardCharsets.UTF_8.encode("vbx !");
        try(FileChannel fileChannel = new RandomAccessFile("hello/demo01.txt","rw").getChannel()){
            fileChannel.write(new ByteBuffer[]{str1,str2,str3,str4});
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
