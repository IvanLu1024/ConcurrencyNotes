package code_02_threadSafeStrategy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 18351 on 2018/11/6.
 *
 * 多个线程访问同一个方法的局部变量时，不会出现线程安全问题，
 * 因为局部变量存储在虚拟机栈中，属于线程私有的。
 */
//@ThreadSafe
public class StackClosedExample {
    public void add100() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        StackClosedExample example = new StackClosedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> example.add100());
        executorService.execute(() -> example.add100());
        executorService.shutdown();
    }
}
//输出结果：100
//输出结果：100
