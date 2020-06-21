package main.java.com.concurrency.chapter1;

/**
 * @author : lengxin
 * @date : 2020/6/2 23:03
 */
public class TryConcurrency {
    public static void main(String[] args) {
//        Thread t1 = new Thread("Custom-Thread") {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    println("Task 1=>" + i);
//                    try {
//                        Thread.sleep(1000L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        t1.start();   //  如果不调用start()， t1只是一个普通的对象，并不是线程
//
//        for (int j = 0; j < 100; j++) {
//            println("Task 2=>" + j);
//        }

        new Thread("Read-Thread") {     // 局部内部类
            @Override
            public void run() {
                println(Thread.currentThread().getName());
                readFromDatabase();
            };
        }.start();    // 如果直接调用run()，（相当于调用实例方法）不会启动一个新线程

        new Thread("Read-Thread") {
            @Override
            public void run() {writeDataToFile();};
        }.start();

    }

    private static void readFromDatabase() {
        try {
            println("Begin read data form db.");
            Thread.sleep(1000 * 10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }

    private static void writeDataToFile() {
        try {
            println("Begin write data to file.");
            Thread.sleep(1000 * 10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }
    private static void println(String message){
        System.out.println(message);
    }

}
