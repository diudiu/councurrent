package main.java.com.concurrency.chapter2;

/**
 * @author : lengxin
 * @description : 通过runnable接口将业务数据单独抽取出来，与线程分离
 * @date : 2020/6/3 23:35
 */
public class TicketWindowRunnable implements Runnable {
    private int index = 1;
    private final static int MAX = 50;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " number is: " + index++);
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
