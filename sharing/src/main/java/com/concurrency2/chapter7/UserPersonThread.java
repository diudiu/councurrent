package main.java.com.concurrency2.chapter7;

import java.awt.desktop.AppReopenedEvent;

/**
 * @author : lengxin
 * @description :
 * @date : 2020/6/21 15:55
 */
public class UserPersonThread extends Thread {
    private Person person;

    public UserPersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " print " + person.toString());
        }
    }
}
