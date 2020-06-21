package main.java.com.concurrency2.chapter4;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/20 17:07
 */
public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();
}
