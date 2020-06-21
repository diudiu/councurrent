package main.java.com.concurrency2.chapter3;

/**
 * @author : lengxin
 * @description : 当两个线程都有写操作时， INIT_VALUE是交替递增的
 *                volatile不保证原子性
 *                i++   1. read i; 2. i+1; 3. write i
 *                线程执行到任何一步都肯能被切换出去
 * @date : 2020/6/17 23:17
 */
public class VolatileTest2 {
    private volatile static int INIT_VALUE = 0;
    private final static int MAX_LIMIT = 500;

    public static void main(String[] args) {
        new Thread(()->{
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.println("T1-> " + (++INIT_VALUE));
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "READER-1").start();

        new Thread(()->{
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.println("T2-> " + (++INIT_VALUE));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "READER-2").start();
    }
}
