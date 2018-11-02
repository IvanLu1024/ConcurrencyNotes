package code_00_threadSafe.atomic;

import annoations.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 18351 on 2018/11/2.
 */
@ThreadSafe
public class Code_05_SynchronizedDemo {
    // 修饰一个代码块
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("test1 {"+j+"}-{"+i+"}");
            }
        }
    }

    // 修饰一个方法
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println("test2 {"+j+"}-{"+i+"}");
        }
    }

    public static void main(String[] args) {
        Code_05_SynchronizedDemo example1 = new Code_05_SynchronizedDemo();
        Code_05_SynchronizedDemo example2 = new Code_05_SynchronizedDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test2(1);
        });
        executorService.execute(() -> {
            example2.test2(2);
        });
    }
}
