package main.java.com.concurrency.chapter9;

import java.util.stream.Stream;

/**
 * @author : lengxin
 * @description : notify是从LOCK锁的wait队列中随机选一个唤醒（不同的jvm有不同的唤醒机制，可能随机，可能FIFO）
 *                notifyAll唤醒所有LOCK锁的wait队列中的所有线程
 *                唤醒的线程从wait的地方接着执行
 *                wait几乎都是和while配合使用的
 * @date : 2020/6/8 23:40
 */
public class ProduceConsumerVersion3 {
    private int i = 0;

    private final Object LOCK = new Object();

    private volatile boolean isProduced = false;

    public void produce() {
        synchronized (LOCK) {
            while (isProduced) { // 为什么用while不用wait？因为线程唤醒后从wait的地方接着执行，
                try {            // 如果唤醒多个produce，可能导致覆盖生产数据
                    LOCK.wait();  // wait几乎都是和while配合使用
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            i++;
            System.out.println(Thread.currentThread().getName() + "->" + i);
            LOCK.notifyAll();
            isProduced = true;

        }
    }

    public void consumer() {
        synchronized (LOCK) {
            while (!isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "->" + i);
            LOCK.notifyAll();
            isProduced = false;
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion3 pc = new ProduceConsumerVersion3();
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
