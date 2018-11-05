package code_01_publishObject.singleton;

import annoations.ThreadSafe;

/**
 * 饿汉式
 * 单例实例在类装载的时候进行创建
 *
 * 缺点：
 * 1.如果创建过程中进行很多的运算，会导致类加载的时候特别的慢
 * 2.如果创建出来的实例要很久以后才被调用，那么会导致资源的浪费
 * @author
 */
@ThreadSafe
public class Singleton2 {
    private Singleton2(){}

    private static Singleton2 instance=new Singleton2();

    public static Singleton2 getInstance(){
        return instance;
    }
}
