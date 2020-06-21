package main.java.com.concurrency.chapter5;

/**
 * @author : lengxin
 * @description : 多个线程并发去采集机器信息，将每一次采集的信息做为一个批次保存下来。
 * @date : 2020/6/7 11:38
 */
public class ThreadJoin3 {
    public static void main(String[] args) throws InterruptedException {
        long starTimestamp = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 10000L));
        Thread t2 = new Thread(new CaptureRunnable("M2", 30000L));
        Thread t3 = new Thread(new CaptureRunnable("M3", 15000L));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long endTimeStamp = System.currentTimeMillis();
        System.out.printf("Save data begin timestamp is: %s, end timestamp is: %s\n", starTimestamp, endTimeStamp);

    }
}

class CaptureRunnable implements Runnable {
    private String machineName;
    private long spendTime;

    public CaptureRunnable(String machineName, long spendTime){
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.printf(this.machineName + " completed data capture at timestamp [%s] and successfully\n", System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getResult(){
        return machineName + " finish.";
    }
}