package code_01_publishObject.singleton;

import annoations.NotThreadSafe;

/**
 * 懒汉式
 * TODO:单例实例在第一次使用时进行创建
 */
@NotThreadSafe
public class Singleton1 {
    private Singleton1(){}

    private static Singleton1 instance=null;

    public static Singleton1 getInstance(){
        if(instance==null){
            //在判断instance是否为空的时候可能存在线程不安全的现象
            instance=new Singleton1();
        }
        return instance;
    }
}
