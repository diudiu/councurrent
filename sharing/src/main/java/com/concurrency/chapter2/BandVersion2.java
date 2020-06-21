package main.java.com.concurrency.chapter2;

/**
 * @author : lengxin
 * @description : 对于第一个版本， 启多少个线程，内存中就会有多少分逻辑数据和执行逻辑的代码（run)
 *                此版本不管定义多少个线程， 业务逻辑的实例只有一个，从而实现业务逻辑与线程控制分离（单一原则）。
 * @date : 2020/6/3 23:38
 */
public class BandVersion2 {
    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable(); // 业务逻辑
        Thread windowThread1 = new Thread(ticketWindowRunnable, "counter 1");  // 线程控制
        Thread windowThread2 = new Thread(ticketWindowRunnable, "counter 2");
        Thread windowThread3 = new Thread(ticketWindowRunnable, "counter 3");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
