package main.java.com.concurrency.chapter6;

import java.util.TreeMap;

/**
 * @author : lengxin
 * @description : 方法二：利用interrupt
 * @date : 2020/6/7 16:42
 */
public class ThreadCloseGraceful2 {
    private static class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    break; // return;
//                }
                if (isInterrupted()) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }
}
