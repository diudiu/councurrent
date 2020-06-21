package main.java.com.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author : lengxin
 * @description : join阻塞当前线程，等待所有子线程运行结束。
 * @date : 2020/6/7 11:13
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            IntStream.range(1, 1000).forEach(i->System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        Thread t2 = new Thread(()->{
            IntStream.range(1, 1000).forEach(i->System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();


        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000).forEach(i->System.out.println(Thread.currentThread().getName() + "->" + i));
    }
}
