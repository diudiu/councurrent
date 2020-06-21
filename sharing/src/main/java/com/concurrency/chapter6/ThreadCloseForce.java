package main.java.com.concurrency.chapter6;

/**
 * @author : lengxin
 * @description :  如何关闭一个在Runnable内部没有机会判断start flag或调用isInterrupted()的线程。
 *                 比如线程正在做很耗时的文件操作，或connection。
 *                 解决办法是封装一个executeThread， 将这个耗时线程作为executeThread的daemon线程，
 *                 当interrupt executeThread, daemon线程也同时退出。
 *                 存疑： 为什么executeThread shutdown后， daemon线程runner还在运行
 * @date : 2020/6/7 16:50
 */
public class ThreadCloseForce {
//    private static class Worker extends Thread {
//        @Override
//        public void run() {
//            while (true) {
//                // connection
//            }
//        }
//    }

    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(() -> {
            // load a very heavy resource.
             while (true) {
                 try {
                     Thread.sleep(1_000);
                     System.out.println("runner");
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
        });
        service.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        try {
            Thread.sleep(10000);   // 让main线程多运行一会
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
