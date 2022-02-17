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
 *
 *
 * byteBuffer 有三个中套参数  position  limit  cap
 *
 * (1)写模式：从哪里开始写    clear   compect
 * clear从头开始
 * compect从为读取位置开始
 *
 * position就根据使用方法的不同设置不同的位置
 *
 * limit 为最大位置
 *
 *
 * （2）flip读取模式：
 * 读取模式，position从头开始 0  ；limit是可以读取的最远位置
 *
 * （2）
 */
public class _1_ByteBufferDemo {
    static final Logger log = LoggerFactory.getLogger(_1_ByteBufferDemo.class);
    public static void main(String[] args) {
        readFile();
////        writeData();
//        byteToString();
//        stringToByte();
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

    private static void readFile() {
        //创建方法   堆内存创建方法  缓存区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        try (RandomAccessFile file = new RandomAccessFile("hello/demo.txt","rw")){
            //得到通道
            FileChannel channel = file.getChannel();
            do{
                //channel读取，写入buffer     读取需要一个地方进行临时缓冲
                int len = channel.read(buffer);
                log.info("字节长度 {}",len);
                if (len == -1){
                    break;
                }
                //读取模式
                buffer.flip();
                ByteBufferUtil.debugAll(buffer);
                //一个一个读取
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
