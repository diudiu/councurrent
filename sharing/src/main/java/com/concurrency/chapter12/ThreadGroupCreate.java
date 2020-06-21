package main.java.com.concurrency.chapter12;

import java.util.Arrays;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/11 23:05
 */
public class ThreadGroupCreate {
    public static void main(String[] args) throws InterruptedException {
        // use the name
        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1") {
            @Override
            public void run() {
                try {
                    System.out.println(getThreadGroup().getName());
                    System.out.println(getThreadGroup().getParent());
                    System.out.println(getThreadGroup().getParent().activeCount());
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        ThreadGroup tg2 = new ThreadGroup("TG2");
        Thread t2 = new Thread(tg2, "T2") {
            @Override
            public void run() {
                System.out.println(tg1.getName());
                Thread[] threads = new Thread[tg1.activeCount()];
                tg1.enumerate(threads);
                Arrays.asList(threads).forEach(System.out::println);
            }
        };
        t2.start();

        // use the parent and group name
        ThreadGroup tg3 = new ThreadGroup(tg1, "TG3");
        System.out.println(tg3.getName());
    }
}
