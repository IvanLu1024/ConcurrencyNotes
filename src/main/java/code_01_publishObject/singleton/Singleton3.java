package code_01_publishObject.singleton;

/**
 * 懒汉式
 * TODO:单例实例在第一次使用时进行创建
 * 使用synchronied会十分影响性能，所以并不推荐
 */
//@ThreadSafe
//@NotRecommend
public class Singleton3 {
    private Singleton3(){}

    private static Singleton3 instance=null;

    public static synchronized Singleton3 getInstance(){
        if(instance==null){
            //在判断instance是否为空的时候可能存在线程不安全的现象
            instance=new Singleton3();
        }
        return instance;
    }
}
