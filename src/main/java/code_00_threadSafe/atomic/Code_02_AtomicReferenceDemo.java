package code_00_threadSafe.atomic;

import annoations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 18351 on 2018/11/2.
 */
@ThreadSafe
public class Code_02_AtomicReferenceDemo {
    private static AtomicReference<Integer> count=
            new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);
        //如果值为0，就将 count更新为2
        count.compareAndSet(0,1); //不执行
        count.compareAndSet(0,1); //不执行
        count.compareAndSet(1,3); //不执行
        count.compareAndSet(2,4); //count=4
        count.compareAndSet(3,5); //不执行
        System.out.println("count:{"+count+"}");
    }
}
