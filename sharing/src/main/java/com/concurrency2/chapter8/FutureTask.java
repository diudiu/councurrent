package main.java.com.concurrency2.chapter8;

/**
 * @author : lengxin
 * @description :  call()相当于SyncInvoker的get()方法真正做的事情
 * @date : 2020/6/21 18:44
 */
public interface FutureTask<T> {
    T call();
}
