package main.java.com.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/7 11:25
 */
public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(()-> {
//            try {
//                System.out.println("t1 is running");
//                Thread.sleep(10_000);
//                System.out.println("t1 is done");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t1.start();
//        t1.join(100);
//
//        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
//        IntStream.range(1, 1000).forEach(i->System.out.println(Thread.currentThread().getName() + "->" + i));
//
        Thread.currentThread().join();  //currentThread是main, main线程在等待main线程结束，
        // main线程线程在等待main线程结束（但是main线程还有事情在做，没有结束）
    }
}
