package code_01_publishObject.singleton;

import annoations.NotThreadSafe;

/**
 * 懒汉式
 * 双重同步锁机制
 * TODO:单例实例在第一次使用时进行创建
 */
@NotThreadSafe
public class Singleton4 {
    private Singleton4(){}

    private static Singleton4 instance=null;

    public static Singleton4 getInstance(){
        if(instance==null){
            synchronized (Singleton4.class){
                //在判断instance是否为空的时候可能存在线程不安全的现象
                if(instance==null){
                    instance=new Singleton4();
                }
            }
            /**
             * instance=new Singleton();这段代码分三步执行。
             * 1.分配内存空间
             * 2.初始化对象
             * 3.将instance指向分配的内存地址
             *
             * 但是由于JVM具有指令重排的特性，有可能执行顺序变为了1-->3-->2,这在单线程情况下自然是没有问题的。
             * 但如果是在多线程下，有可能获得的是因为还没有被初始化的实例，导致程序出错。
             */
        }
        return instance;
    }
}
