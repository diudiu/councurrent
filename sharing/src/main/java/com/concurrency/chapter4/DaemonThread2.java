package main.java.com.concurrency.chapter4;

/**
 * @author : lengxin
 * @description :  A(client)<------------------长连接---------------->B(server)
 *                长连接需要定期发生心跳包证明链接是可用的，如果链接不可以需要重新链接，
 *                当长连接退出，心跳检查也停止，但是发送心跳跟业务逻辑没有太大相关性，
 *                没必要单独写代码维护心跳退出逻辑。
 *                因此可以创建一个DaemonThread(health check)
 *                设置成daemon模式，当主线程退出，daemon线程也自动结束
 *                如果设置成非daemon模式，可能导致应用程序无法退出，因为有非daemon线程active
 * @date : 2020/6/7 0:14
 */
public class DaemonThread2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(()->{
                try {
                    while (true) {
                        System.out.println("Do some thing for health check.");
                        Thread.sleep(1_000);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            innerThread.setDaemon(true);
            innerThread.start();

            try {
                Thread.sleep(3_000);
                System.out.println("t thread finish done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();

        Thread.sleep(10_000);  // 当只有daemon线程是， jvm退出
    }
}

