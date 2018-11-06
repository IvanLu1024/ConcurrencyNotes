package code_01_publishObject;

/**
 * Created by 18351 on 2018/11/5.
 * 对象溢出的实例
 */
public class Code_01_Escape {
    private int thisCanBeEscape=0;

    public Code_01_Escape(){
        //this 引用溢出
        //Code_01_Escape的构造方法中有InnerClass对象
        //InnerClass内部可以使用Code_01_Escape的this引用
        //如果this引用在构造方法中，被别的对象使用到，这样的this引用所指的对象被认为是没有正确构建的。
        new InnerClass(); //内部类实例
    }

    /**
     * 包含了对封装实例的隐藏和引用，这样
     * TODO:在对象没有被正确构造完成之前就会被发布，由此导致不安全的因素在里面
     * 1. 导致this引用在构造期间溢出的错误，他是在构造函数构造过程中启动了一个线程，造成this引用的溢出
     * 2. 新线程只是在对象构造完毕之前就已经看到他了，所以如果要在构造函数中创建线程，那么不要启动它，
     * 而是应该用一个专有的start，或是其他的方式统一启动线程
     * 3. 使用工厂方法和私有构造函数来完成对象创建和监听器的注册来避免不正确的发布
     */
    private class InnerClass{
        public InnerClass() {
            System.out.println(Code_01_Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        Code_01_Escape escape=new Code_01_Escape();
        String
    }
}
