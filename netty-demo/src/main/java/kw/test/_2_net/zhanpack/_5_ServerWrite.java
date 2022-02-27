package kw.test._2_net.zhanpack;

/**
 * 一次写入大量的数据，无法一次发送完成，
 * server可以通过读取buffer是不是已经读取完成来判断，不断的进行遍历，问题就是如果
 * bytebuffer特别大就会造成这个线程堵塞，使其无法处理其他通道。
 *
 *  if (buffer.hasRemaining()) {
 *           sc.write(buffer);//一直进行写*
 *  }
 *
 *   这样如果非常大，那么就会一直等待，也无法做其他事情
 *
 *
 *
 *   改进，修改一下关注的事件
 *
 *    int write = sc.write(buffer);
 *                     // 3. write 表示实际写了多少字节
 *                     System.out.println("实际写入字节:" + write);
 *                     // 4. 如果有剩余未读字节，才需要关注写事件
 *                     if (buffer.hasRemaining()) {
 *                         // read 1  write 4
 *                         // 在原有关注事件的基础上，多关注 写事件
 *                         sckey.interestOps(sckey.interestOps() + SelectionKey.OP_WRITE);
 *                         // 把 buffer 作为附件加入 sckey
 *                         sckey.attach(buffer);
 *                     }
 *
 *   关注写事件，然后写完之后需要清除缓存区，并且将关注的事件也进行更改。
 */
public class _5_ServerWrite {
}
