package main.java.com.concurrency.chapter3;

import java.util.Arrays;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/5 23:46
 */
public class CreateThread2 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        System.out.println(t.getThreadGroup());
        System.out.println(Thread.currentThread().getName());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());

        System.out.println(threadGroup.activeCount());

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        for(Thread temp: threads) {
            System.out.println(temp);
        }

        Arrays.asList(threads).forEach(System.out::println);  // java8写法
    }
}
