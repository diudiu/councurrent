package main.java.com.concurrency.chapter10;

import main.java.com.concurrency.chapter7.SynchronizedStatic;

/**
 * @author : lengxin
 * @description : synchronized的问题： 如果一个线程占用synchronized很长时间，其他线程无法允许， 只能等待这个线程释放锁
 *                而且t2也无法被打断
 * @date : 2020/6/10 23:00
 */
public class SynchronizedProblem {
    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                SynchronizedProblem.run();
            }
        }.start();

        Thread.sleep(1000);

        Thread t2 = new Thread() {
            @Override
            public void run() {
                SynchronizedProblem.run();
            }
        };
        t2.start();
        Thread.sleep(2000);
        t2.interrupt();
        System.out.println(t2.isInterrupted());

    }
    private synchronized static void run() {
        System.out.println(Thread.currentThread().getName());
        while (true) {

        }
    }
}
