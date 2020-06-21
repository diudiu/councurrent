package main.java.com.concurrency2.chapter4;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/20 17:13
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
