package kw.test._2_selector;

/**
 * bio：堵塞的，每一个请求通道需要一个线程来处理，创建线程需要浪费资源。
 *    线程切换上下文成本高。适合在连接数量不多的场景。
 *
 *
 *  线程池版本：
 *      可以节约创建和回收线程，但是一个线程也仅处理一个连接，适合在短链接的场景。
 *
 *  selecctor，使用一个线程来管理多个channel,通过获取channel上的事件。不会造成堵塞。适合连接多，流量低。
 *
 *  那个channel存在事件了，就将线程交给那个channel执行操作。
 */
public class App {
}
