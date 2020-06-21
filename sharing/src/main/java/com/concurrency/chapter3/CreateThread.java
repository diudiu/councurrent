package main.java.com.concurrency.chapter3;

/**
 * @author : lengxin
 * @description : thread lifecycle
 *     ---> create(new) ----> runnable ---------------> terminated
 *                            .   ▲    ▲                  ▲  ▲
 *                            .   .      .             .     .
 *                            .   .        .         .       .
 *                            .   .           .    .         .
 *                            .   .          blocked         .
 *                            .   .            ▲             .
 *                            .   .         .                .
 *                            .   .      .                   .
 *                            ▼   .   .                      .
 *                           running -------------------------
 *
 * @date : 2020/6/5 23:06
 */
public class CreateThread {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        System.out.println(t.getName());

        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println(">>>>>>这是一个内部内<<<<<<");
            }
        };
        t1.start();
        System.out.println(t1.getName());

        Thread t2 = new Thread("MyName");
        System.out.println(t2.getName());

        Thread t3 = new Thread(()->{
            System.out.println("Runnable of t3");
        });
        System.out.println(t3.getName());

        Thread t4 = new Thread(() -> {
            System.out.println("Runnable of t4 " + Thread.currentThread().getName());
        }, "RunnableThread");
        t4.start();
    }
}
