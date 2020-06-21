package main.java.com.concurrency.chapter7;

/**
 * @author : lengxin
 * @description : 运行此代码，用jps找到SynchronizedTest的PID，`jstack pid`命令查看线程堆栈。
 *                发现只有一个线程state是`TIMED_WAITING (sleeping)`，其他线程state是`BLOCKED (on object monitor)`
 * @date : 2020/6/7 21:37
 */
public class SynchronizedTest {
    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        Runnable runnable = ()->{
            synchronized (LOCK) {
                try {
                    Thread.sleep(300_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }
}
