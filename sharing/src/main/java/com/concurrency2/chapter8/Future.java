package main.java.com.concurrency2.chapter8;

/**
 * @author : lengxin
 * @description : 别人调用的时候返回future，通过future的get方法获取真正的结果
 * @date : 2020/6/21 18:43
 */
public interface Future<T> {
    T get() throws InterruptedException;
}
