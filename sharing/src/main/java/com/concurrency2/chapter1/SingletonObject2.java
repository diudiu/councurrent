package main.java.com.concurrency2.chapter1;

/**
 * @author : lengxin
 * @description :  如果两个线程同时执行到if(null==instance)这一行， 其中一个放弃CPU执行权，另一个线程new了一个instance,
 *                 当第一个线程重新获得CPU执行权时，会再new一个instance，这样就可能出现多个instance， 就不是单例的了。
 *                 实现了lazy load, 但是不是严格单例
 * @date : 2020/6/15 22:56
 */
public class SingletonObject2 {
    private static SingletonObject2 instance;

    private SingletonObject2() {
        // empty
    }

    public static SingletonObject2 getInstance() {
        if (null == instance) {            //
            instance = new SingletonObject2();
        }
        return SingletonObject2.instance;
    }
}
