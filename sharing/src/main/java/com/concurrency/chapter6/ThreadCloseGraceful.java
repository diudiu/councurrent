package main.java.com.concurrency.chapter6;

/**
 * @author : lengxin
 * @description : 方式一：通过flag开关
 * @date : 2020/6/7 16:34
 */
public class ThreadCloseGraceful {
    private static class Worker extends Thread {
        private volatile boolean start = true;
        @Override
        public void run() {
            while (start) {

            }
        }

        public void shutdown() {
            this.start = false;
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.shutdown();
    }
}
