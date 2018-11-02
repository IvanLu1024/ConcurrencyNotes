package code_00_threadSafe.atomic;

import annoations.ThreadSafe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by 18351 on 2018/11/2.
 */
@ThreadSafe
public class Code_03_AtomicReferenceFieldUpdaterDemo {
    private static AtomicIntegerFieldUpdater<Code_03_AtomicReferenceFieldUpdaterDemo> updater =
            AtomicIntegerFieldUpdater.newUpdater(Code_03_AtomicReferenceFieldUpdaterDemo.class, "count");

    private volatile int count=100;

    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        Code_03_AtomicReferenceFieldUpdaterDemo self=
                new Code_03_AtomicReferenceFieldUpdaterDemo();

        if (updater.compareAndSet(self, 100, 120)) {
            System.out.println("update success 1, {"+self.getCount()+"}");
        }
        if (updater.compareAndSet(self, 100, 120)) {
            System.out.println("update success 2, {"+self.getCount()+"}");
        } else {
            System.out.println("update failed 2, {"+self.getCount()+"}");
        }
    }
}
//update success 1, {120}
//update failed 2, {120}
