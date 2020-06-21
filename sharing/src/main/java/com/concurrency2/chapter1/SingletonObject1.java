package main.java.com.concurrency2.chapter1;

/**
 * @author : lengxin
 * @description : can't lazy load.
 * @date : 2020/6/15 22:52
 */
public class SingletonObject1 {
    private static final SingletonObject1 instance = new SingletonObject1();
    private SingletonObject1() {
        // empty
    }

    public static SingletonObject1 getInstance() {
        return instance;
    }
}
