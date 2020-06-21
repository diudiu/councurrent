package main.java.com.concurrency.chapter9;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/8 22:47
 */
public class ProduceConsumerVersion1 {
    private int i = 1;
    private final Object LOCK = new Object();

    private void produce() {
        synchronized (LOCK) {
            System.out.println("p->" + i++);
        }
    }

    private void consume() {
        synchronized (LOCK) {
            System.out.println("c->" + i);
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion1 pc = new ProduceConsumerVersion1();
        new Thread("p") {
            @Override
            public void run() {
                while (true) {
                    pc.produce();
                }
            }
        }.start();

        new Thread("c") {
            @Override
            public void run() {
                while (true) {
                    pc.consume();
                }
            }
        }.start();
    }
}
