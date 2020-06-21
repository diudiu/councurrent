package main.java.com.concurrency2.chapter6;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/21 11:01
 */
public class ReadWriteLockClient {
    public static void main(String[] args) {
        final SharedData sharedData = new SharedData(10);
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new WriterWorker(sharedData, "jgfgrdgfdhjdsfdfgfgf").start();
        new WriterWorker(sharedData, "JGFGRDGFDHJDSFDFGFGF").start();
    }
}
