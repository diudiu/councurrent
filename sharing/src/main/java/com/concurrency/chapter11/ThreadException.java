package main.java.com.concurrency.chapter11;

/**
 * @author : lengxin
 * @description : 无法捕获线程的异常， 因为run方法签名不能抛异常
 *                setUncaughtExceptionHandler可以注入hook处理异常
 * @date : 2020/6/11 0:28
 */
public class ThreadException {
//    private final static int A = 10;
//    private final static int B = 0;
//
    public static void main(String[] args) {
//        Thread t = new Thread(()->{
//            try {
//                Thread.sleep(1000);
//                int result = A/B;
//                System.out.println(result);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t.setUncaughtExceptionHandler((thread, e)->{
//            System.out.println(e);
//            System.out.println(thread);
//        });
//        t.start();

        new Test1().test();
    }
}
