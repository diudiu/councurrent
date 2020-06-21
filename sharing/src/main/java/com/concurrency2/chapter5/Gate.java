package main.java.com.concurrency2.chapter5;

/**
 * @author : lengxin
 * @description : gate相当于共享资源(SharedResource),
 *                使用this锁，保证只有一个人（线程）通过。如果不使用会导致线程不安全
 *                verify和toString是读操作， 也加了this锁， 导致整体效率比较低。
 * @date : 2020/6/20 22:30
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String address) {
        this.counter ++;
        this.name = name;         // name/address是临界值，对其操作会发生race condition
        this.address = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("*********BROKEN********" + toString());
        }
    }

    public synchronized String toString() {
        return "No." + counter + ":" + name + "," + address;
    }
}
