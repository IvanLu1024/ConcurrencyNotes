package code_02_threadSafeStrategy;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * Created by 18351 on 2018/11/6.
 */
//@ThreadSafe
public class Code_00_Immutable {
    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1,3);
    }
}
/**输出结果：
 * Exception in thread "main" java.lang.UnsupportedOperationException
 */
