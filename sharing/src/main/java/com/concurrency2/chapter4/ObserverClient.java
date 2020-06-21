package main.java.com.concurrency2.chapter4;

/**
 * @author : lengxin
 * @description :  https://www.runoob.com/design-pattern/observer-pattern.html
 * @date : 2020/6/20 17:16
 */
public class ObserverClient {
    public static void main(String[] args) {
        final Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);
        System.out.println("=================");
        subject.setState(10);
        System.out.println("=================");
        subject.setState(15);
        System.out.println("=================");
        subject.setState(15);
    }
}
