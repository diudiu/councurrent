package main.java.com.concurrency.chapter10;

import java.awt.desktop.ScreenSleepEvent;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author : lengxin
 * @description : 为了解决synchronized一直等待的问题，设计了一个超时锁， 如果等待时间过长直接抛异常
 * @date : 2020/6/10 22:33
 */
public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        final BooleanLock booleanLock = new BooleanLock();
        Stream.of("T1", "T2", "T3", "T4")
                .forEach(name ->
                        new Thread(()->{
                            try {
                                booleanLock.lock(10000);  // 这里抢锁实际上抢的是booleanLock这个instance，lock函数返回实际上booleanLock已经释放了
                                                     // 为什么其他线程不继续抢这个锁呢， 因为其他线程处于wait状态，等待被唤醒
                                Optional.of(Thread.currentThread().getName() + " have the block monitor")
                                        .ifPresent(System.out::println);
                                work();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (Lock.TimeOutException e) {
                                Optional.of(Thread.currentThread().getName() + " time out")
                                        .ifPresent(System.out::println);
                            } finally {
                                booleanLock.unlock();
                            }
                        }, name).start()
                );
    }

    private static void work() {
        try {
            Optional.of(Thread.currentThread().getName() + " is working...")
                    .ifPresent(System.out::println);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
