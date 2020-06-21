package main.java.com.concurrency.chapter7;

/**
 * @author : lengxin
 * @description : chapter2的银行排队系统，存在一个问题，最终输出index可能超过MAX。
 *                其原因是：可能三个线程同时在index=499时执行到code1，然后sleep(5)， 然后三个线程分别执行了code3将index++
 *                javap -c .class file 查看反汇编代码
 * @date : 2020/6/7 18:35
 */
public class TicketWindowRunnable implements Runnable {
    private int index = 1;
    private final static int MAX = 500;
    private final Object MONITOR = new Object();

    @Override
    public void run() {
        while (true) {
            // 如果不同步， 会导致输出的最大值大于500
//            if(index > MAX) break;  // 1
//            try {
//                Thread.sleep(5);     // 2
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread() + " number is: " + index++);  // 3

            // 用synchronized包起来后，能做到线程同步
            synchronized (MONITOR) {
                // 1
                if(index > MAX) break;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " number is: " + index++);
                // 2   1和2之间的代码是串行执行的， 单线程
            }
        }
    }
}
