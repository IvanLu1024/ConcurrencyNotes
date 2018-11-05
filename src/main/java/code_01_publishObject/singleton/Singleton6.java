package code_01_publishObject.singleton;

import annoations.NotThreadSafe;
import annoations.ThreadSafe;

/**
 * 懒汉式
 *
 * 不同的静态代码块是按照顺序执行的
 */
@ThreadSafe
public class Singleton6 {
    private Singleton6(){}

    private static Singleton6 instance=null;

    static {
        instance=new Singleton6();
    }

    public static Singleton6 getInstance(){
        return instance;
    }
}
