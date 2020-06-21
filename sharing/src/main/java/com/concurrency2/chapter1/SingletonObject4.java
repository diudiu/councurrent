package main.java.com.concurrency2.chapter1;

/**
 * @author : lengxin
 * @description : 使用double check解决， 存在dcl失效问题
 *                1） 严格单例
 *                2） 懒加载
 *                3） 性能问题
 *                但是可能会引起空指针异常
 * @date : 2020/6/15 23:09
 */
public class SingletonObject4 {
    private static SingletonObject4 instance;

    private SingletonObject4() {
        // empty
    }

    public static SingletonObject4 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject4.class) {
                if (null == instance) {
                    instance = new SingletonObject4();
                }
            }
        }
        return SingletonObject4.instance;
    }
}
