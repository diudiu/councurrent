package main.java.com.concurrency.chapter8;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/8 0:00
 */
public class DeadLock {
    private OtherService otherService;

    public DeadLock(OtherService otherService) {
        this.otherService = otherService;
    }

    private final Object lock = new Object();
    public void m1() {
        synchronized (lock) {
            System.out.println("m1");
            otherService.s1();
        }
    }

    public void m2() {
        synchronized (lock) {
            System.out.println("m2");
        }
    }

}
