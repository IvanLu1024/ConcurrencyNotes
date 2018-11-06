package code_02_threadSafeStrategy.synchronizedContainer;

import java.util.List;
import java.util.Vector;

/**
 * Created by 18351 on 2018/11/6.
 */
//@NotThreadSafe
public class VectorExample1 {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    //Vector是同步容器
    public static List<Integer> list = new Vector<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //输出结果： java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 5
                list.remove(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            //输出结果： java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 5
            // thread2想获取i=5的元素的时候，thread1将i=5的元素移除了，导致数组越界
            for (int i = 0; i < 10; i++) {
                list.get(i);
            }
        });

        thread1.start();
        thread2.start();
    }
}
