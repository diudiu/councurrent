package main.java.com.concurrency.chapter4;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/6 22:45
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " running");
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName() + " done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t.setDaemon(true);
        t.start();

        Thread.sleep(5_000);
        System.out.println(Thread.currentThread().getName());
    }
}

