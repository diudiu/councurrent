package main.java.com.concurrency2.chapter1;

/**
 * @author : lengxin
 * @description : 使用volatile能解决可能会引起空指针异常的问题
 * @date : 2020/6/15 23:25
 */
public class SingletonObject5 {
    private static volatile SingletonObject5 instance;

    private SingletonObject5() {
        // empty
    }

    public static SingletonObject5 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject5.class) {
                if (null == instance) {
                    instance = new SingletonObject5();
                }
            }
        }
        return SingletonObject5.instance;
    }
}
