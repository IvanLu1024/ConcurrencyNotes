package code_00_threadSafe.atomic;

import annoations.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 18351 on 2018/11/2.
 */
@ThreadSafe
public class Code_06_SynchronizedDemo {
    // 修饰一个类
    public static void test1(int j) {
        synchronized (Code_06_SynchronizedDemo.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println("test1 {"+j+"} - {"+i+"}");
            }
        }
    }

    // 修饰一个静态方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println("test1 {"+j+"} - {"+i+"}");
        }
    }

    public static void main(String[] args) {
        Code_06_SynchronizedDemo example1 = new Code_06_SynchronizedDemo();
        Code_06_SynchronizedDemo example2 = new Code_06_SynchronizedDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }
}
