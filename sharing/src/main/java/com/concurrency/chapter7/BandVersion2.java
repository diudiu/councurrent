package main.java.com.concurrency.chapter7;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/7 18:38
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
