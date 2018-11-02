package code_00_threadSafe.atomic;

import annoations.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 18351 on 2018/11/2.
 */
@ThreadSafe
public class Code_07_ReentrantLockDemo {
    private Lock lock = new ReentrantLock();

    public void test1(int j) {
        lock.lock();
        try{
            for (int i = 0; i < 10; i++) {
                System.out.println("test1 {"+j+"} - {"+i+"}");
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Code_07_ReentrantLockDemo example1=new Code_07_ReentrantLockDemo();
        Code_07_ReentrantLockDemo example2=new Code_07_ReentrantLockDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                example1.test1(1);
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                example2.test1(2);
            }
        });
    }
}
