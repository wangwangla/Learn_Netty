package kw.test.jdkfuture;

import java.util.concurrent.*;

public class _5_JdkFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //jdk的一般会关联线程池来进行的
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> submit = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 40;
            }
        });
        System.out.println("wait result");
        //等待
        System.out.println("result "+submit.get());
        System.out.println("----- after");

    }
}
