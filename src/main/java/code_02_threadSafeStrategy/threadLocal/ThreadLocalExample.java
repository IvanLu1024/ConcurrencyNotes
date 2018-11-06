package code_02_threadSafeStrategy.threadLocal;

/**
 * Created by 18351 on 2018/11/6.
 *
 * 如果一段代码中所需要的数据必须与其他代码共享，那就看看这些共享数据的代码是否能保证在同一个线程中执行。
 * 如果能保证，我们就可以把共享数据的可见范围限制在同一个线程之内，
 * 这样，无须同步也能保证线程之间不出现数据争用的问题。
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            threadLocal.remove();
        });
        thread1.start();
        thread2.start();
    }
}
//输出结果：1
/**
 * thread1 中设置 threadLocal 为 1，而 thread2 设置 threadLocal 为 2。
 * 过了一段时间之后，thread1 读取 threadLocal 依然是 1，不受 thread2 的影响。
 */
