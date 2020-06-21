package main.java.com.concurrency.chapter11;

import main.java.com.concurrency.chapter6.ThreadInterrupt;

/**
 * @author : lengxin
 * @description : 给程序注入hook，优雅处理异常退出，释放占用资源
 * @date : 2020/6/11 0:06
 */
public class ExitCapture {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("The application will be exit.");
            notifyAndRelease();
        }));

        int i = 0;
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println("I am working....");
                i++;
                if (i>10) throw new RuntimeException("Error");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void notifyAndRelease() {
        System.out.println("notify to the admin.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I will release resource(socket, file connection)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Release down");
    }
}
