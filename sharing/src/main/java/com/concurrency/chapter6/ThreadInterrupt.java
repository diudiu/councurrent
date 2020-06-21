package main.java.com.concurrency.chapter6;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/7 11:56
 */
public class ThreadInterrupt {
    private static final Object MONITOR = new Object();
    public static void main(String[] args) {
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                while(true) {
////                    System.out.println(">>>" + this.isInterrupted());
////                    try {
////                        Thread.sleep(10);
////                    } catch (InterruptedException e) {
////                        System.out.println("receive interrupt signal");
////                        e.printStackTrace();
////                    }
//                    synchronized (MONITOR) {
//                        try {
//                            MONITOR.wait(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                            System.out.println(isInterrupted());
//                        }
//                    }
//                }
//            }
//        };
//        t.start();
//        Thread.sleep(100);
//        System.out.println(t.isInterrupted());
//        t.interrupt();
//        System.out.println(t.isInterrupted());
//
//        t.stop();

//        Thread t = new Thread(()->{
//            while (true) {
//                synchronized (MONITOR) {
//                        try {
//                            MONITOR.wait(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                            System.out.println(Thread.interrupted());
//                        }
//                    }
//            }
//
//        });

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        t.start();

        Thread main = Thread.currentThread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                main.interrupt();  // 需要打断的是main线程
//                t.interrupt();     // 而不是t线程
                System.out.println("interrupt");
            }
        };
        t2.start();

        try {
            t.join();  // join的是main线程，所以interrupt也要打断main线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
