package code_01_publishObject.singleton;

/**
 * 枚举方式
 */
public class Singleton7 {
    private Singleton7(){}

    public static Singleton7 getInstance(){
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton{
        INSTANCE;
        //如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。
        //而且 Java 要求必须先定义 enum 实例
        private Singleton7 singleton;

        //JVM保证这个方法绝对只被调用一次
        Singleton(){
            singleton=new Singleton7();
        }

        public Singleton7 getSingleton() {
            return singleton;
        }
    }
}
