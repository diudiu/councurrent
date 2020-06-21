package main.java.com.concurrency.chapter7;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/7 22:16
 */
public class BankVersion3 {
    public static void main(String[] args) {
        final SynchronizedRunnable synchronizedRunnable = new SynchronizedRunnable();
        Thread windowThread1 = new Thread(synchronizedRunnable, "counter 1");
        Thread windowThread2 = new Thread(synchronizedRunnable, "counter 2");
        Thread windowThread3 = new Thread(synchronizedRunnable, "counter 3");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
