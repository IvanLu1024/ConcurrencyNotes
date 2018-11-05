package code_00_threadSafe.visibility;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by 18351 on 2018/11/5.
 */
public class Code_00_VolatileDemo {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static volatile int count = 0;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count{"+count+"}");
    }

    private static void add() {
        count++;
        // 1、count
        // 2、+1
        // 3、count
    }
}
//第一次输出结果：count{4992}
//第二次输出结果：count{4997}
//第三次输出结果：count{4997}
//第四次输出结果：count{4999}
//TODO:使用 volatile 修饰变量count，不能解决线程不安全问题，因为 volatile 并不能保证操作的原子性。
