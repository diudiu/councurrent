package main.java.com.concurrency.chapter6;

/**
 * @author : lengxin
 * @description : runner线程是一个比较耗时的操作，在执行过程中可能没有机会判断是否被打断。
 *                但有时候runner线程运行时间过长，希望有种机制能让runner线程退出。
 *                因此引入executeThread， executeThread负责创建runner子线程和监听interrupt中断， 并将runner线程设置成daemon，
 *                如果runner运行时间过长，executeThread被打断退出，同时其daemon的子线程也将同时退出
 * @date : 2020/6/7 16:56
 */
public class ThreadService {
    private Thread executeThread;
    private boolean finished = false;

    public void execute(Runnable task) {
        executeThread = new Thread() {
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);

                runner.start();
                try {
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                }
            }
        };
        executeThread.start();
    }

    public void shutdown(long mills) {
        long currentTime = System.currentTimeMillis();
        while (!finished) {
            if ((System.currentTimeMillis() - currentTime) >= mills) {
                System.out.println("任务超时， 需要结束它！");
                executeThread.interrupt();
                break;
            }

            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断！");
                break;
            }
        }
        finished = false;
    }
}
