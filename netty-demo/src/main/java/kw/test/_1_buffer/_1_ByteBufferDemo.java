package kw.test._1_buffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import kw.test.utils.ByteBufferUtil;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class _1_ByteBufferDemo {
    static final Logger log = LoggerFactory.getLogger(_1_ByteBufferDemo.class);
    public static void main(String[] args) {
        //创建方法   堆内存创建方法  缓存区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        try (RandomAccessFile file = new RandomAccessFile("hello/demo.txt","rw")){
            //得到通道
            FileChannel channel = file.getChannel();
            do{
                //channel读取，写入buffer
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
                buffer.clear();//pos 0 .limit == cap
                ByteBufferUtil.debugAll(buffer);
            }while (true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
