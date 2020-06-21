package main.java.com.concurrency.chapter9;

import main.java.com.concurrency.chapter6.ThreadInterrupt;

import java.util.stream.Stream;

/**
 * @author : lengxin
 * @description : 1. sleep is the method of Thread, but the wait is the method of Object.
 *                2. sleep will not release the object monitor(Lock), but the wait will be release the monitor and add to Object monitor waiting queue.
 *                3. use sleep not depend on the monitor, but wait need need.
 *                4. The sleep method not need be wakeup, but wait need.
 * @date : 2020/6/9 0:16
 */
public class DifferenceOfWaitAndSleep {
    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        Stream.of("T1", "T2").forEach(name ->
                new Thread(name) {
                    @Override
                    public void run() {
                        DifferenceOfWaitAndSleep.m2();
                    }
                }.start()
        );
    }

    public static void m1() {
        synchronized (LOCK) {
            try {
                System.out.println("The Thread " + Thread.currentThread().getName() + " enter.");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m2() {
        synchronized (LOCK) {
            try {
                System.out.println("The Thread " + Thread.currentThread().getName() + " enter.");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
