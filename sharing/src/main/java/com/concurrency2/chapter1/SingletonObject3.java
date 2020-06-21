package main.java.com.concurrency2.chapter1;

/**
 * @author : lengxin
 * @description :  通过加锁能解决创建多个实例的问题， 但是每次读instance都要加锁， 严重影响了性能。
 *                 实现了lazy load 和严格单例， 但是有性能问题
 * @date : 2020/6/15 23:02
 */
public class SingletonObject3 {
    private static SingletonObject3 instance;

    private SingletonObject3() {
        // empty
    }

    public synchronized static SingletonObject3 getInstance() {
        if (null == instance) {
            instance = new SingletonObject3();
        }
        return SingletonObject3.instance;
    }
}
