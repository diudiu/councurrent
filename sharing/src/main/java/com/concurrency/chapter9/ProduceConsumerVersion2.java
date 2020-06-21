package main.java.com.concurrency.chapter9;

import main.java.com.concurrency.chapter6.ThreadInterrupt;

import javax.swing.table.TableRowSorter;
import java.util.stream.Stream;

/**
 * @author : lengxin
 * @description : 使用notify在多个produce和consumer的情况下会出现假死现象，所有线程都在wait
 *                生产者唤醒了生产者，使用notifyAll就没问题.
 *                wait状态的线程会放弃CPU执行权，等待notify唤醒，但每次notify只随机唤醒一个线程。
 * @date : 2020/6/8 22:54
 */
public class ProduceConsumerVersion2 {
    private int i = 0;

    private final Object LOCK = new Object();

    private volatile boolean isProduced = false;

    public void produce() {
        synchronized (LOCK) {
            if (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println(Thread.currentThread().getName() + "->" + i);
                LOCK.notify();
                isProduced = true;
            }
        }
    }

    public void consumer() {
        synchronized (LOCK) {
            if (isProduced) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
                LOCK.notify();
                isProduced = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion2 pc = new ProduceConsumerVersion2();
        Stream.of("P1", "P2").forEach(n ->
                new Thread(n) {
                    @Override
                    public void run() {
                        while (true) {
                            pc.produce();
                        }
                    }
                }.start()
        );


        Stream.of("C1", "C2").forEach(n ->
                new Thread(n) {
                    @Override
                    public void run() {
                        while (true) {
                            pc.consumer();
                        }
                    }
                }.start()
        );
    }
}
