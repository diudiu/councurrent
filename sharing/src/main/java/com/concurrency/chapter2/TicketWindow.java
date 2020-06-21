package main.java.com.concurrency.chapter2;

/**
 * @author : lengxin
 * @description : 此版本存在的问题：1）static的属性的生命周期过长，不会随着实例的消失而消失；
 *                2）业务逻辑和线程控制不分离
 *                3）不是线程安全的
 * @date : 2020/6/3 23:16
 */
public class TicketWindow extends Thread{
    private final String name;
    private static final int MAX = 50;
    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("counter: " + this.name + " current number is: " + index++);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
