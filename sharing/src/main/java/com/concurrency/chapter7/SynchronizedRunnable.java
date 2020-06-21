package main.java.com.concurrency.chapter7;

import main.java.com.concurrency.chapter6.ThreadInterrupt;

import javax.swing.table.TableRowSorter;

/**
 * @author : lengxin
 * @description : 同步代码有两种方式， 一种是同步代码块， 另一种是同步方法（同步方法默认锁是this）
 *                锁的范围要尽可能小
 * @date : 2020/6/7 22:15
 */
public class SynchronizedRunnable implements Runnable {
    private int index = 1;

    private final static int MAX = 500;

    private final Object MONITOR = new Object();

    // lock是this，如果直接同步run方法将只有一个线程能执行业务逻辑
//    @Override
//    public synchronized void run() {
//        while (true) {
//            if (index > MAX) {
//                break;
//            }
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread() + " number is: " + index++);
//        }
//    }


    @Override
    public void run() {
        while (true) {
            if (ticket()) break;
        }
    }

    private synchronized boolean ticket() {
        // 1. getField
        if (index > MAX) {
            return true;
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // index++ => index = index + 1
        // 1. get field index
        // 2. index = index + 1
        // 3. put field index
        System.out.println(Thread.currentThread() + " number is: " + index++);
        return false;
    }
}
