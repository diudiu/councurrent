package main.java.com.concurrency2.chapter8;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/21 18:43
 */
public interface Future<T> {
    T get() throws InterruptedException;
}
