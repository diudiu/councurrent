package main.java.com.concurrency2.chapter4;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/20 17:23
 */
public class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Hexa String: " + Integer.toHexString(subject.getState()));
    }
}
