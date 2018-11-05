package code_01_publishObject;

import annoations.NotThreadSafe;
import annoations.ThreadSafe;

import java.util.Arrays;

/**
 * Created by 18351 on 2018/11/5.
 * 不安全的对象发布
 */
@NotThreadSafe
public class Code_00_UnsafePublish {
    private String[] arr={"1","2","3"};

    /**
     * 通过public发布级别发布了类的域，在类的外部，任何线程都可以访问这个域.
     * 这样是不安全的，因为我们无法检查其他线程是否会修改这个域导致了错误
     */
    public String[] getArr(){
        return arr;
    }

    public static void main(String[] args) {
        Code_00_UnsafePublish unsafePublish=new Code_00_UnsafePublish();
        System.out.println(Arrays.toString(unsafePublish.getArr()));
        //输出结果：[1,2,3]

        //修改该成员变量中私有属性的值
        unsafePublish.getArr()[0]="4";
        System.out.println(Arrays.toString(unsafePublish.getArr()));
        //输出结果：[4,2,3]
    }
}
