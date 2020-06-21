package main.java.com.concurrency2.chapter1;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/15 23:27
 */
public class SingletonObject6 {
    private SingletonObject6() {

    }

    private static class InstanceHolder {
        private final static SingletonObject6 instance = new SingletonObject6();
    }

    public static SingletonObject6 getInstance() {
        return InstanceHolder.instance;
    }
}
