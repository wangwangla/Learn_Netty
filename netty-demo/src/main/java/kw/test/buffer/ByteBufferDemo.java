package kw.test.buffer;

import kw.test.utils.ByteBufferUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * ByteBuffer常见方法
 *
 * allocate:
 * compect:
 * write :
 * get:
 * mark:
 * reset:
 *
 *
 * 非线程安全的
 */
public class ByteBufferDemo {
    static final Logger log = LoggerFactory.getLogger(ByteBufferDemo.class);
    public static void main(String[] args) {
//        methodReadData();
//        writeData();
        byteToString();
        stringToByte();
    }

    private static void stringToByte() {
        ByteBuffer hello = StandardCharsets.UTF_8.encode("hello");
        ByteBufferUtil.debugAll(hello);
        ByteBuffer buffer2 = Charset.forName("utf-8").encode("hello");
        ByteBufferUtil.debugAll(buffer2);
    }

    private static void byteToString() {

    }

    private static void writeData() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        //put
        buffer.put((byte) 1);
        ByteBufferUtil.debugAll(buffer);
    }

    private static void methodReadData() {
        //创建方法   堆内存创建方法
        ByteBuffer buffer = ByteBuffer.allocate(10);
        try (RandomAccessFile file = new RandomAccessFile("hello/demo.txt","rw")){
            FileChannel channel = file.getChannel();
            do{
                int len = channel.read(buffer);
                log.info("字节长度 {}",len);
                if (len == -1){
                    break;
                }
                buffer.flip();
                ByteBufferUtil.debugAll(buffer);
                while (buffer.hasRemaining()){
                    log.info("value{}",(char)buffer.get());
                }
                ByteBufferUtil.debugAll(buffer);
                buffer.clear();
                ByteBufferUtil.debugAll(buffer);
            }while (true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
