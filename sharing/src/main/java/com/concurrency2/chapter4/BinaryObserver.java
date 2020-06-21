package main.java.com.concurrency2.chapter4;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/20 17:11
 */
public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
